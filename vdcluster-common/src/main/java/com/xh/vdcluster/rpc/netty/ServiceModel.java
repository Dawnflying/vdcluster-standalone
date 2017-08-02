package com.xh.vdcluster.rpc.netty;

import java.util.List;

/**
 * Created by bloom on 2017/8/1.
 */
public class ServiceModel {

    public int nodeId;

    public String name;

    public List<Object> args;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getArgs() {
        return args;
    }

    public void setArgs(List<Object> args) {
        this.args = args;
    }
}
