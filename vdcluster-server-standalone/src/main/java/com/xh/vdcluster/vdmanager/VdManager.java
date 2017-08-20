package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.DetectType;
import com.xh.vdcluster.repository.mapper.ServantMapper;
import com.xh.vdcluster.repository.model.Stream;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bloom on 2017/8/20.
 */
public class VdManager {


    @Resource
    VdServantManager vdServantManager;

    @Resource
    ServantMapper servantMapper;

    public void init(){

        List<Stream> streamList = servantMapper.listAll();
        List<DetectServiceConfiguration> configurationList = new ArrayList<>();

        for(Stream s: streamList){
            DetectServiceConfiguration configuration = new DetectServiceConfiguration();
            configuration.setFrameWidth(300);
            configuration.setFrameHeight(200);
            configuration.setStreamURL(s.getUri());
            configuration.setServiceId(VdServantManager.generateServantId(s.getUri()));
            List<DetectType> detectTypes = new ArrayList<>();
            detectTypes.add(new DetectType("smoke", 0.9));
            configuration.setDetectType(detectTypes);
            configuration.setStreamType(0);
            configuration.setDecodeMode(0);
            configurationList.add(configuration);
        }

        vdServantManager.createServants(configurationList);

    }
}
