package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.Md5Utils;
import com.xh.vdcluster.vdmanager.beans.VdNode;
import com.xh.vdcluster.vdmanager.beans.VdServantBean;
import java.util.*;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdServantManager extends AbstractServantAdapter {


    public static String generateServantId(String url) {
        return Md5Utils.MD5(url);
    }


    private VdServantManager() {
        super();
    }

    /**
     * 创建servants
     * @param configurationList
     * @return
     */
    public List<VdServantBean> createServants(List<DetectServiceConfiguration> configurationList) {
        List<VdServantBean> servants = new ArrayList<>();
        for (DetectServiceConfiguration configuration : configurationList) {
            VdServantBean servant = new VdServantBean(configuration);
            servants.add(servant);
            String servantId = generateServantId(configuration.streamURL);
            this.servantMaps.put(servantId, servant);
        }
        return servants;
    }

    /**
     * 停止服务列表,如果servantIds为空,则停止用户的所有服务,如果servantIds不为空,则停止列表中
     * 所有正在运行的服务。
     *
     * @param servantIds 服务列表
     * @return
     */
    public List<VdServantBean> stopServants(List<String> servantIds) {

        List<VdServantBean> servantBeans = this.getServantsAvailable(servantIds);

        return servantBeans;
    }

    /**
     * 删除所有的servants
     * @param servantIds
     * @return
     */
    public List<VdServantBean> removeServants(List<String> servantIds) {

        List<VdServantBean> servantBeans = this.getServantsAvailable(servantIds);

        for (String servantId : servantIds) {
            if (servantMaps.containsKey(servantId)) {
                servantMaps.get(servantId).setState(VdServantBean.DELETING);
            }
        }

        return servantBeans;
    }

    /**
     * 获取和用户id相关的可用的servant的列表。
     *
     * @param servantIds
     * @return
     */
    private List<VdServantBean> getServantsAvailable(List<String> servantIds) {

        List<VdServantBean> servants = new ArrayList<>(servantMaps.values());

        if (servantIds.size() == 0) {
            return servants;
        }

        List<VdServantBean> servantsAvailable = new ArrayList<>();

        for (String sid : servantIds) {
            for (VdServantBean servant : servants) {
                if (servant.getServantId() == sid) {
                    servantsAvailable.add(servant);
                }
            }
        }

        return servantsAvailable;
    }


    public List<VdNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<VdNode> nodeList) {
        this.nodeList = nodeList;
    }
}
