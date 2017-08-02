package com.xh.vdcluster.rpc;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.ServerContext;
import org.apache.thrift.server.TServerEventHandler;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by macbookpro on 17/7/26.
 */
public class DetectServiceEventHandler implements TServerEventHandler {
    @Override
    public void preServe() {

    }

    @Override
    public ServerContext createContext(TProtocol tProtocol, TProtocol tProtocol1) {
        return null;
    }

    @Override
    public void deleteContext(ServerContext serverContext, TProtocol tProtocol, TProtocol tProtocol1) {

    }

    @Override
    public void processContext(ServerContext serverContext, TTransport inputTransport, TTransport outputTransport) {
    /**
    * 把TTransport对象转换成TSocket，然后在TSocket里面获取Socket，就可以拿到客户端IP
    */
        TSocket socket = (TSocket) inputTransport;
        System.out.println(socket.getSocket().getRemoteSocketAddress());

        System.out.println("method invoke ... ");



    }
}
