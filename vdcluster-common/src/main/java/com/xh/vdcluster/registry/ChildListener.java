package com.xh.vdcluster.registry;

import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;

import java.util.List;

/**
 * Created by juemingzi on 16/7/11.
 */
public interface ChildListener extends PathChildrenCacheListener{

    void childChanged(String path, List<String> children) throws Exception;

}
