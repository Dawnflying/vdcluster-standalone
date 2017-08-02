package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.rpc.*;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bloom on 2017/7/26.
 */
@Component
public class DetectServiceImpl implements DetectService.Iface {
    private static final Logger log = LoggerFactory.getLogger(DetectServiceImpl.class);

    @Resource
    DetectServiceAdapter detectServiceAdapter;

    @Override
    public void ping() throws TException {
        detectServiceAdapter.ping();
    }

    @Override
    public void addService(DetectServiceConfiguration serviceConfig)  {
        detectServiceAdapter.addService(serviceConfig);
    }

    @Override
    public SeviceStatusType deleteService(String serviceId)  {

        return detectServiceAdapter.deleteService(serviceId);

    }

    @Override
    public SeviceStatusType checkService(String serviceId) {
        return detectServiceAdapter.checkService(serviceId);
    }

    @Override
    public int getMaxServiceNum()  {
        return detectServiceAdapter.getMaxServiceNum();
    }

    @Override
    public List<String> getServices()  {
        return detectServiceAdapter.getServices();
    }
}
