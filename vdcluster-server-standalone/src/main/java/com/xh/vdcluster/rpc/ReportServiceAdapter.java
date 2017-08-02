package com.xh.vdcluster.rpc;

import org.apache.thrift.TProcessor;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bloom on 2017/7/26.
 */
public class ReportServiceAdapter  {

    private static ExecutorService pool = Executors.newCachedThreadPool();

    public ReportServiceAdapter(int serverPort, ReportService.Iface service) {

        pool.submit(() -> {
            try {

                TProcessor processor = new LogProcessor(new ReportService.Processor(service));

                TServerTransport serverTransport = new TServerSocket(serverPort);

                // Use this for a multithreaded server
                TServer server = new TSimpleServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

                server.serve();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }


}
