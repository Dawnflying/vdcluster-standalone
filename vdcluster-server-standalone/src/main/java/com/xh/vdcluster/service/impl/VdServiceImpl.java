package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.authenication.TokenManager;
import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.VdResultErrorCode;
import com.xh.vdcluster.repository.mapper.*;
import com.xh.vdcluster.repository.model.*;
import com.xh.vdcluster.service.VdService;
import com.xh.vdcluster.vdmanager.VdServantManager;
import com.xh.vdcluster.vdmanager.beans.VdServantBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbookpro on 17/7/22.
 */
@Component
public class VdServiceImpl implements VdService {

    @Resource
    UserMapper userMapper;

    @Resource
    StreamMapper streamMapper;

    @Resource
    ServantMapper servantMapper;

    @Resource
    VdServantManager vdServantManager;



    @Override
    public VdResult addServant(String userId, List<DetectServiceConfiguration> configurationList) {

        User user = userMapper.getUserByUserId(userId);

        if (user == null)
            return new VdResult("auth failed", VdResultErrorCode.AUTH_FAILED, null, userId);

        Integer grain = user.getGrain();

        if (configurationList.size() > grain)
            return new VdResult("servant overload", VdResultErrorCode.SERVANT_OVERLOAD, null, userId);

        String servantId = "";
        for (DetectServiceConfiguration configuration : configurationList) {
            servantId = VdServantManager.generateServantId(configuration.getStreamURL());

            Stream s = streamMapper.selectByUri(configuration.getStreamURL());

            Integer streamId = 0;

            if(s != null)
                streamId = s.getId();
            else {
                Stream stream = new Stream();
                stream.setServantId(servantId);
                stream.setUri(configuration.getStreamURL());
                streamId = streamMapper.insert(stream);
            }

            Servant servant = new Servant();
            servant.setServantid(servantId);
            servant.setStreamid(streamId);
            servant.setUserid(user.getId());

            servantMapper.insert(servant);
        }

        List<VdServantBean> servants = vdServantManager.createServants(configurationList);

        return new VdResult(
                "success to add servant", VdResultErrorCode.SERVANT_SUCCESS, servants, userId);
    }

    @Override
    public VdResult stopServant(String userId, List<String> servantIds) {

        User user = userMapper.getUserByUserId(userId);

        if (user == null)
            return new VdResult("ok", VdResultErrorCode.AUTH_FAILED, null, userId);

        List<VdServantBean> vdServants = vdServantManager.stopServants(servantIds);

        return new VdResult("ok", VdResultErrorCode.SERVANT_SUCCESS, vdServants, userId);
    }

    @Override
    public VdResult removeServant(String userId, List<String> servantIds) {

        List<VdServantBean> vdServants = vdServantManager.removeServants(servantIds);

        return new VdResult("ok", VdResultErrorCode.SERVANT_SUCCESS, vdServants, userId);
    }

    @Override
    public List<Servant> listAllServant(Integer pageIndex, Integer pageSize, Integer pageCount) {

        return servantMapper.listAllServant(pageIndex*pageCount,pageSize);
    }


}
