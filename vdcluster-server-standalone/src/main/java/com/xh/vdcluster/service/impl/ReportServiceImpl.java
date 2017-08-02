package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.DetectType;
import com.xh.vdcluster.common.FastdfsHelper;
import com.xh.vdcluster.rpc.*;
import com.xh.vdcluster.service.MessageService;
import org.apache.thrift.TException;
import org.csource.fastdfs.ClientGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bloom on 2017/7/29.
 */
@Component
public class ReportServiceImpl implements ReportService.Iface {
    private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Resource
    MessageService messageService;

    @Override
    public void ping() throws TException {

        ExecutorService pool = Executors.newSingleThreadExecutor();

        //申请远程服务
        pool.submit(() -> {
            try {
                DetectServiceAdapter detectServiceInAdapter = new DetectServiceAdapter("10.200.9.130", 9090);
                detectServiceInAdapter.addListener("test", new TransportListener() {
                    @Override
                    public void onConnected() {
                        List<DetectType> detectTypes = new ArrayList<>();
                        detectTypes.add(new DetectType("smoke", 0.9));
                        DetectServiceConfiguration configuration = new DetectServiceConfiguration();
                        configuration.setDetectType(detectTypes);
                        configuration.setStreamType(0);
                        configuration.setDecodeMode(0);
                        configuration.setServiceId("123123123123123");
                        configuration.setFrameHeight(300);
                        configuration.setFrameWidth(400);
                        configuration.setStreamURL("rtsp://admin:hk1234567890@10.200.9.225:554/h264/ch1/sub/av_stream");
                        detectServiceInAdapter.addService(configuration);
                    }

                    @Override
                    public void onDisconnected() {

                    }

                    @Override
                    public void onConnectFailed() {

                    }

                    @Override
                    public void onClosed() {

                    }
                });

                detectServiceInAdapter.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        return;
    }

    @Override
    public void reportServiceStatus(DetectStatus detectStatus) throws TException {
        log.info(detectStatus.toString());
        System.out.println(detectStatus.toString());
    }

    @Override
    public void sendSeriveDetectResult(DetectResult detectResult) throws TException {
        try {
            ClassPathResource fileResource = new ClassPathResource("/config/fdfs_client.conf");
            ClientGlobal.init(fileResource.getFile().getAbsolutePath());
            String picUrl = detectResult.getPreviewPicURL();
            String newUrl = FastdfsHelper.uploadFile(picUrl);
            detectResult.setPreviewPicURL(newUrl);
            messageService.pushMessage("", detectResult.toString());
            System.out.println(detectResult.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
