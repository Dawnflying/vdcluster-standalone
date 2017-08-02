package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.vdmanager.beans.VdNode;

/**
 * Created by bloom on 2017/8/2.
 */
public interface VdNodeHandler {

    void addNode(VdNode node);

    void removeNode(String nodeId);
}
