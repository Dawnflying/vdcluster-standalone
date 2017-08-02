package com.xh.vdcluster.rpc;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bloom on 2017/7/26.
 */
public abstract class AbstractServiceAdapter {

    private TTransport transport;

    private TProtocol protocol;

    protected DetectService.Client client;

    private ExecutorService pool = Executors.newCachedThreadPool();

    private boolean isConnected = false;

    private boolean isStopped = false;

    private Timer timer;

    private String host;

    private int port;

    private ConcurrentMap<String, TransportListener> listeners;

    protected AbstractServiceAdapter(String host, int port) {
        this.host = host;
        this.port = port;
        listeners = new ConcurrentHashMap<>();
    }

    public void start(){
        try {
            this.transport = new TSocket(host, port);
            this.transport.open();
            this.protocol = new TBinaryProtocol(this.transport);
            this.client = new DetectService.Client(this.protocol);
            this.timer = new Timer();

            for(TransportListener listener: listeners.values()){
                listener.onConnected();
            }
        } catch (TException t) {

        }
    }

    public void addListener(String name, TransportListener transportListener) {
        listeners.put(name, transportListener);
    }

    private class RetryTask extends TimerTask {
        @Override
        public void run() {
            tryOpen();
        }
    }

    public void tryOpen() {
        if (isConnected) return;

        // Make sure it's closed
        transport.close();

        try {
            transport.open();
            isConnected = true;

            for(TransportListener listener: listeners.values()){
                listener.onConnected();
            }

            return;
        } catch (TTransportException e) {

        }

        timer.schedule(new AbstractServiceAdapter.RetryTask(), 5 * 1000);
    }

    protected void disConnect(){

        for(TransportListener listener: listeners.values()){
            listener.onDisconnected();
        }

        timer.schedule(new AbstractServiceAdapter.RetryTask(), 5 * 1000);
    }


}

