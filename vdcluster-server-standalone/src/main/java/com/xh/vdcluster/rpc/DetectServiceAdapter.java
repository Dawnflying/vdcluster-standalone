package com.xh.vdcluster.rpc;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by bloom on 2017/7/28.
 */
public class DetectServiceAdapter extends AbstractServiceAdapter  {

    public DetectServiceAdapter(String host, int port) throws TException {
        super(host,port);
    }


    public void ping() {
        try {
            client.ping();
        } catch (TException t) {

        }
    }

    public void addService(DetectServiceConfiguration serviceConfig){
        try {
            client.addService(serviceConfig);
        } catch (TException t) {

        }
    }

    public SeviceStatusType deleteService(String serviceId) {
        try {
            return client.deleteService(serviceId);
        } catch (TException t) {

            return null;
        }
    }

    public SeviceStatusType checkService(String serviceId) {
        try {
            return client.checkService(serviceId);
        } catch (TException t) {
            return null;

        }
    }

    public int getMaxServiceNum() {
        try {
            return client.getMaxServiceNum();
        } catch (TException t) {

            return 0;
        }
    }

    public List<String> getServices() {
        try {
            return client.getServices();
        } catch (TException t) {

            return null;
        }
    }

}
