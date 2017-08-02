package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.rpc.DetectServiceAdapter;
import com.xh.vdcluster.rpc.TransportListener;
import com.xh.vdcluster.vdmanager.beans.VdNode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by macbookpro on 17/7/23.
 */
public class VdNodeManager implements VdNodeHandler {

    private ConcurrentMap<String, VdNode> NodeMap = new ConcurrentHashMap<>();

    private VdNodeManager() {
    }

    @Override
    public void addNode(VdNode node) {
        this.NodeMap.putIfAbsent(node.getNodeId(), node);
    }

    @Override
    public void removeNode(String nodeId) {
        if (!NodeMap.containsKey(nodeId))
            return;
        VdNode node = NodeMap.get(nodeId);
        this.NodeMap.remove(nodeId, node);
    }
}
