package com.xh.vdcluster.rpc;

/**
 * Created by bloom on 2017/8/1.
 */
public interface ServiceHandler {

    void register(String serviceName, ServiceBase serviceBase);

    void unregister(String serviceName, ServiceBase serviceBase);

}
