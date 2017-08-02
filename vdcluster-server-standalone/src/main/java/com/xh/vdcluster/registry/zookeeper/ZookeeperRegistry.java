package com.xh.vdcluster.registry.zookeeper;

import com.xh.vdcluster.common.URL;
import com.xh.vdcluster.registry.ChildListener;
import com.xh.vdcluster.registry.RegistryService;

import java.util.List;

/**
 * Created by macbookpro on 17/7/16.
 */
public class ZookeeperRegistry implements RegistryService {

    private ZkClient zkClient;

    public ZookeeperRegistry(String zookeeperUrl) {
        this.zkClient = new CuratorZkClient(zookeeperUrl);
    }

    public void register(URL url) throws Exception{
        zkClient.create(url);
    }

    @Override
    public void unregister(URL url) throws Exception {
        zkClient.delete(url);
    }

    @Override
    public void subscribe(URL url, ChildListener listener) throws Exception{
        zkClient.addNodeListener(url,listener);
    }

    @Override
    public void unsubscribe(URL url, ChildListener listener) throws Exception{

    }

    @Override
    public List<URL> lookup(URL url) {
        return null;
    }
}
