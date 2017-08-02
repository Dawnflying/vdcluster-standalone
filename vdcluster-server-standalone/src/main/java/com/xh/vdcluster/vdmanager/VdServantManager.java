package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.Md5Utils;
import com.xh.vdcluster.repository.mapper.ServantMapper;
import com.xh.vdcluster.rpc.DetectService;
import com.xh.vdcluster.vdmanager.beans.VdServant;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdServantManager extends AbstractServantAdapter {

    @Resource
    DetectService.Iface detectService;

    private VdServantManager() {
    }

    private static VdServantManager INSTANCE = new VdServantManager();

    public static VdServantManager getInstance() {
        return INSTANCE;
    }

    public static String generateServantId(String url) {
        return Md5Utils.MD5(url);
    }

    public VdServant createServant(DetectServiceConfiguration configuration) {
        return new VdServant(configuration);
    }

    public List<VdServant> createServants(List<DetectServiceConfiguration> configurationList) {
        List<VdServant> servants = new ArrayList<>();
        for (DetectServiceConfiguration configuration : configurationList) {
            VdServant servant = new VdServant(configuration);
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
     * @param userId     用户id
     * @param servantIds 服务列表
     * @return
     */
    public List<VdServant> stopServants(String userId, List<String> servantIds) {
        List<VdServant> servants = this.getServantsAvailable(userId, servantIds);

        for (VdServant vds : servants) {

        }
        return servants;
    }

    public List<VdServant> removeServants(String userId, List<String> servantIds) {

        List<VdServant> servants = this.getServantsAvailable(userId, servantIds);

        for (VdServant vds : servants) {
            servantMaps.remove(vds);
        }
        return servants;
    }

    /**
     * 获取和用户id相关的可用的servant的列表。
     *
     * @param userId
     * @param servantIds
     * @return
     */
    private List<VdServant> getServantsAvailable(String userId, List<String> servantIds) {
        List<VdServant> servants = new ArrayList<>(servantMaps.values());

        if (servantIds.size() == 0) {
            //删除当亲啊用户所有的servant
            return servants;
        }
        List<VdServant> servantsAvailable = new ArrayList<>();

        for (String sid : servantIds) {
            for (VdServant servant : servants) {
                if (servant.getServantId() == sid) {
                    servantsAvailable.add(servant);
                }
            }
        }
        return servantsAvailable;
    }
}
