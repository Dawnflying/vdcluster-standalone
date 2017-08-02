package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.registry.model.Node;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by macbookpro on 17/7/23.
 */
public class NodeManager {

    private ConcurrentMap<String, Node> NodeMap = new ConcurrentHashMap<>();

    private NodeManager() {
    }

    private static NodeManager INSTANCE = new NodeManager();

    public static NodeManager getInstance() {
        return INSTANCE;
    }

    public void addNode(Node node) {
        this.NodeMap.putIfAbsent(node.getNodeId(), node);
    }

    public void removeNode(String nodeId) {
        if (!NodeMap.containsKey(nodeId))
            return;
        Node node = NodeMap.get(nodeId);
        this.NodeMap.remove(nodeId, node);
    }
}
