package com.xh.vdcluster.rpc;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;


/**
 * Created by bloom on 2017/7/26.
 */
public class ReportServiceAsyncAdapter{

    private static DetectService.Processor processor;
    private static TProtocolFactory protocolFactory ;
    private static TAsyncClientManager asyncClientManager;
    private static TNonblockingSocket nonblockingSocket;
    private static DetectService.AsyncClient asyncClient;

    static {
        try {
            protocolFactory = new TCompactProtocol.Factory();
            asyncClientManager = new TAsyncClientManager();

        } catch (Exception e) {

        }
    }


    public void init(String host, int port, DetectService.Iface service, AsyncMethodCallback<Void> callback) {

        try {

            nonblockingSocket = new TNonblockingSocket(host, port);
            asyncClient = new DetectService.AsyncClient(protocolFactory, asyncClientManager, nonblockingSocket);
            asyncClient.addService(null, callback);

            processor = new DetectService.Processor(service);
            TServerTransport serverTransport = new TServerSocket(9090);
//            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
