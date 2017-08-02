package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.DetectType;
import com.xh.vdcluster.common.Md5Utils;
import com.xh.vdcluster.rpc.DetectServiceAdapter;
import com.xh.vdcluster.vdmanager.beans.VdNode;
import com.xh.vdcluster.vdmanager.beans.VdServantBean;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by macbookpro on 17/7/23.
 */
public abstract class AbstractServantAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AbstractServantAdapter.class);

    protected Map<String, VdServantBean> servantMaps = new ConcurrentHashMap<>();

    private ConcurrentMap<String, DetectServiceAdapter> adapterMaps = new ConcurrentHashMap<>();

    private Timer scheduelTimer;

    protected List<VdNode> nodeList;

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
    protected AbstractServantAdapter() {
        scheduelTimer = new Timer();
        task = new ServantTimerTask();
        scheduelTimer.schedule(task, 5000, 5000);
    }

    protected DetectServiceAdapter getAvailableServiceAdapter() {

        for (DetectServiceAdapter adapter : adapterMaps.values()) {

            if (adapter.isConnected) {
                int num = adapter.getMaxServiceNum();

                int servantCount = adapter.getServices().size();

                if (num > servantCount)
                    return adapter;
            }
        }
        return null;
    }


    private void updateNodes() {

        for (VdNode node : nodeList) {

            if (!node.isConnected()) {
                if (node.getNodeId() == null)
                    node.setNodeId(Md5Utils.MD5(node.getIpAddress() + ":" + node.getPort()));
                try {
                    DetectServiceAdapter detectServiceAdapter = new DetectServiceAdapter(node.getIpAddress(), node.getPort());
                    detectServiceAdapter.isConnected = true;
                    adapterMaps.put(node.getNodeId(),detectServiceAdapter);

                }
                catch (TException te){

                }


            }

        }
    }

    /**
     * 调度添加进入的视频识别服务
     * 服务氛围CREATED,RUNNING,STOPPED三种状态，每种状态包含的。
     */
    public void schedule() {
        try {

            updateNodes();

            DetectServiceAdapter detectServiceAdapter = this.getAvailableServiceAdapter();

            if(detectServiceAdapter == null) {
                logger.info("no enough nodes available");
                return;
            }
            List<String> services = detectServiceAdapter.getServices();

            int maxCount = detectServiceAdapter.getMaxServiceNum();

            int slots = maxCount - services.size();

            for (VdServantBean servant : servantMaps.values()) {
                if (services.contains(servant.getServantId()))
                    continue;
                else {

                    if (slots > 0) {

                        if (servant.getState() == VdServantBean.CREATED) {

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
                            detectServiceAdapter.addService(configuration);
                            servant.setState(VdServantBean.RUNNING);

                        }
                    }

                    if (servant.getState() == VdServantBean.DELETING) {
                        slots++;
                        detectServiceAdapter.deleteService(servant.getServantId());
                        servant.setState(VdServantBean.DELETED);
                    }
                }
            }

            for (VdServantBean servant : servantMaps.values()) {
                if (servant.getState() == VdServantBean.DELETED) {
                    servantMaps.remove(servant.getServantId());
                }
            }

        } catch (Exception e) {

        }
    }


}
