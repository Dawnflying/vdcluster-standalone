package com.xh.vdcluster.rpc;

/**
 * Created by bloom on 2017/7/31.
 */
public interface TransportListener {

    void onConnected();

    void onDisconnected();

    void onConnectFailed();

    void onClosed();
}
