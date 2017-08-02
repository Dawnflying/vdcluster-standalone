package com.xh.vdcluster.registry.zookeeper;

import com.xh.vdcluster.common.URL;
import com.xh.vdcluster.registry.ChildListener;
import com.xh.vdcluster.registry.StateListener;

import java.util.List;

/**
 * Created by bloom on 2017/7/13.
 */
public interface ZkClient {

    void create(URL url) throws Exception;

    void delete(URL url) throws Exception;

    List<String> getChildNode(String path) throws Exception;

    void addNodeListener(final URL url, final ChildListener listener) throws Exception;

    void addStateListener(StateListener stateListener);

}