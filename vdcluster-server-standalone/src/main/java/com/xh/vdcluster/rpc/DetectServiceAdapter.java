package com.xh.vdcluster.rpc;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by bloom on 2017/7/28.
 */
public class DetectServiceAdapter extends AbstractServiceAdapter implements DetectService.Iface {

    public DetectServiceAdapter(String host, int port) throws TException {
        super(host,port);
    }

    @Override
    public void ping() {
        try {
            client.ping();
        } catch (TException t) {

        }
    }

    @Override
    public void addService(DetectServiceConfiguration serviceConfig){
        try {
            client.addService(serviceConfig);
        } catch (TException t) {

        }
    }

    @Override
    public SeviceStatusType deleteService(String serviceId) {
        try {
            return client.deleteService(serviceId);
        } catch (TException t) {

            return null;
        }
    }

    @Override
    public SeviceStatusType checkService(String serviceId) {
        try {
            return client.checkService(serviceId);
        } catch (TException t) {
            return null;

        }
    }

    @Override
    public int getMaxServiceNum() {
        try {
            return client.getMaxServiceNum();
        } catch (TException t) {

            return 0;
        }
    }

    @Override
    public List<String> getServices() {
        try {
            return client.getServices();
        } catch (TException t) {

            return null;
        }
    }


}
