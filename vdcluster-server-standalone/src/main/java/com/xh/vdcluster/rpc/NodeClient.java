package com.xh.vdcluster.rpc;

import com.xh.vdcluster.common.URL;
import com.xh.vdcluster.registry.ChildListener;
import com.xh.vdcluster.registry.RegistryService;
import com.xh.vdcluster.registry.zookeeper.ZookeeperRegistryFactory;
import com.xh.vdcluster.rpc.DetectService;
import com.xh.vdcluster.common.DetectServiceConfiguration;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bloom on 2017/7/19.
 */
public class NodeClient {

    public void start() {
        try {
            DetectServiceConfiguration configuration = new DetectServiceConfiguration();
            configuration.setServiceId("test_id_123");
            configuration.setDecodeMode(1);
            configuration.setStreamURL("rtsp://admin:hk1234567890@10.200.9.225:554/h264/ch1/sub/av_stream");
        /*TTransport transport = new TSocket("10.200.9.130", 9090);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        DetectService.Client messagequeue = new DetectService.Client(protocol);

        List<Integer> typeList = new ArrayList<Integer>();
        typeList.add(1);
        typeList.add(2);
        configuration.setDetectType(typeList);
        configuration.setStreamType(1);
        Map<Integer, Double> detectSensitivity = new HashMap<>();
        detectSensitivity.put(1, 0.3);
        detectSensitivity.put(2, 0.4);
        configuration.setDetectSensitivity(detectSensitivity);
        configuration.setFrameWidth(1080);
        configuration.setFrameHeight(768);
 /*       while (true) {
            int result = messagequeue.addService(configuration);
            Thread.sleep(10);
        }*/
//        transport.close();
            TProtocolFactory tProtocolFactory = new TCompactProtocol.Factory();
            TAsyncClientManager tAsyncClientManager = new TAsyncClientManager();
            TNonblockingSocket tNonblockingSocket = new TNonblockingSocket("10.200.9.130", 9090);
            DetectService.AsyncClient asyncClient = new DetectService.AsyncClient(tProtocolFactory, tAsyncClientManager, tNonblockingSocket);

            ZookeeperRegistryFactory factory = new ZookeeperRegistryFactory();
            Map<String, String> parameters = new HashMap<>();
            parameters.put("username", "admin");
            parameters.put("password", "hk123456");
            URL url = new URL("rtsp", "10.200.9.225", 554, "stream", parameters);

            RegistryService service = factory.createRegistry("10.200.8.102:2181");
            service.register(url);
            service.subscribe(url, new ChildListener() {
                @Override
                public void childChanged(String path, List<String> children) throws Exception {

                }

                @Override
                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {

                }
            });
        } catch (Exception e) {

        }

    }

}
