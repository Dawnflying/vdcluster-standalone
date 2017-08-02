package com.xh.vdcluster.rpc;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import java.util.List;

/**
 * Created by macbookpro on 17/7/26.
 */
public class DetectServiceInAsyncAdapter implements DetectService.AsyncIface {

    private static TProtocolFactory protocolFactory;

    private static TAsyncClientManager asyncClientManager;

    private static TNonblockingSocket nonblockingSocket;

    private static DetectService.AsyncClient asyncClient;

    public DetectServiceInAsyncAdapter(String clientHost, int clientPort) {

        try {
            protocolFactory = new TBinaryProtocol.Factory();
            asyncClientManager = new TAsyncClientManager();
            nonblockingSocket = new TNonblockingSocket(clientHost, clientPort);
            asyncClient = new DetectService.AsyncClient(protocolFactory, asyncClientManager, nonblockingSocket);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ping(AsyncMethodCallback<Void> resultHandler) throws TException {

    }

    @Override
    public void addService(DetectServiceConfiguration serviceConfig, AsyncMethodCallback<Void> resultHandler) throws TException {
        asyncClient.addService(serviceConfig, resultHandler);
    }

    @Override
    public void deleteService(String serviceId, AsyncMethodCallback<SeviceStatusType> resultHandler) throws TException {
        asyncClient.deleteService(serviceId, resultHandler);
    }

    @Override
    public void checkService(String serviceId, AsyncMethodCallback<SeviceStatusType> resultHandler) throws TException {

        asyncClient.checkService(serviceId, resultHandler);

    }

    @Override
    public void getMaxServiceNum(AsyncMethodCallback<Integer> resultHandler) throws TException {

    }

    @Override
    public void getServices(AsyncMethodCallback<List<String>> resultHandler) throws TException {

    }

}
