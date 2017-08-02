package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.DetectType;
import com.xh.vdcluster.rpc.DetectService;
import com.xh.vdcluster.vdmanager.beans.VdServant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by macbookpro on 17/7/23.
 */
public abstract class AbstractServantAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AbstractServantAdapter.class);

    protected Map<String, VdServant> servantMaps = new ConcurrentHashMap<>();

    private Timer scheduelTimer;

    @Resource
    DetectService.Iface detectService;

    private static ServantTimerTask task;

    private class ServantTimerTask extends TimerTask {
        @Override
        public void run() {
            schedule();
        }
    }

    /**
     * 每隔五秒调度一次
     */
    public AbstractServantAdapter() {
        scheduelTimer = new Timer();
        task = new ServantTimerTask();
        scheduelTimer.schedule(task, 100, 5000);
    }

    /**
     * 调度添加进入的视频识别服务
     * 服务氛围CREATED,RUNNING,STOPPED三种状态，每种状态包含的。
     */
    public void schedule() {
        try {
            List<String> services = detectService.getServices();
            int maxCount = detectService.getMaxServiceNum();

            int slots = maxCount - services.size();

            for (VdServant servant : servantMaps.values()) {
                if (services.contains(servant.getServantId()))
                    continue;
                else {

                    if (slots > 0) {
                        if (servant.getState() != VdServant.CREATED)
                            continue;
                        slots--;
                        DetectServiceConfiguration configuration = new DetectServiceConfiguration();
                        configuration.setServiceId(servant.getServantId());
                        configuration.setStreamURL(servant.getStream().getUri());
                        List<DetectType> detectTypes = new ArrayList<>();
                        detectTypes.add(new DetectType("smoke", 0.9));
                        configuration.setDetectType(detectTypes);
                        configuration.setStreamType(0);
                        configuration.setDecodeMode(0);
                        configuration.setFrameHeight(300);
                        configuration.setFrameWidth(400);
                        detectService.addService(configuration);
                        servant.setState(VdServant.RUNNING);
                    }
                }
            }

        } catch (Exception e) {

        }
    }


}
