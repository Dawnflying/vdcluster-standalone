package com.xh.vdcluster.registry.zookeeper;

import com.xh.vdcluster.registry.RegistryService;

/**
 * Created by bloom on 2017/7/17.
 */
public class ZookeeperRegistryFactory {

    public RegistryService createRegistry(String zookeeperUrl) {

        return new ZookeeperRegistry(zookeeperUrl);
    }
}
