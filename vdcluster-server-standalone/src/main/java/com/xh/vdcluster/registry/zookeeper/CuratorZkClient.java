package com.xh.vdcluster.registry.zookeeper;

import com.xh.vdcluster.common.URL;
import com.xh.vdcluster.registry.ChildListener;
import com.xh.vdcluster.registry.StateListener;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import java.util.List;

/**
 * Created by macbookpro on 17/7/16.
 */
public class CuratorZkClient implements ZkClient {

    private CuratorFramework client;

    public CuratorZkClient(String url) {
        RetryPolicy retry = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient(url, 5000, 3000,retry);
        client.start();
    }

    @Override
    public void create(URL url) throws Exception {
        client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(url.getPath());
    }

    @Override
    public void delete(URL url) throws Exception {
        client.delete().forPath(url.getPath());
    }

    @Override
    public List<String> getChildNode(String path) throws Exception {
        return client.getChildren().forPath(path);
    }

    @Override
    public void addNodeListener(URL url, ChildListener listener) throws Exception {
        PathChildrenCache cache = new PathChildrenCache(client, url.getPath(), true);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        cache.getListenable().addListener(listener);
    }

    @Override
    public void addStateListener(StateListener stateListener) {

    }
}
