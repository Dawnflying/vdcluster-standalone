package com.xh.vdcluster.vdmanager.beans;

import com.xh.vdcluster.rpc.TransportListener;

import java.util.List;

/**
 * Created by bloom on 2017/8/2.
 */
public class VdNode implements TransportListener {

    /**
     * 识别节点的ID
     */
    private String nodeId;

    /**
     * 识别节点的名称
     */
    private String name;

    /**
     * 识别节点的地址
     */
    private String ipAddress;

    /**
     * 识别节点的端口
     */
    private int port;

    /**
     * 识别节点正在识别的视频
     */
    private List<String> servantList;

    /**
     * 识别节点当前的识别路数
     */
    private int weight;

    /**
     * 识别节点能够承受的最大识别路数
     */
    private int capability;

    /**
     * 当前节点的连接状态
     */
    private boolean isConnected;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<String> getServantList() {
        return servantList;
    }

    public void setServantList(List<String> servantList) {
        this.servantList = servantList;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapability() {
        return capability;
    }

    public void setCapability(int capability) {
        this.capability = capability;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public VdNode(){
        isConnected = false;
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onConnectFailed() {

    }

    @Override
    public void onClosed() {

    }
}
