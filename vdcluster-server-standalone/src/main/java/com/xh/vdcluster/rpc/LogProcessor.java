package com.xh.vdcluster.rpc;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;

/**
 * Created by macbookpro on 17/7/27.
 */
public class LogProcessor implements TProcessor {

    private TProcessor processor;

    public LogProcessor(TProcessor processor){
        this.processor = processor;
    }

    @Override
    public boolean process(TProtocol in, TProtocol out) throws TException {

        TSocket socket = (TSocket)in.getTransport();

        System.out.println(socket.getSocket().getRemoteSocketAddress());

        return processor.process(in, out);
    }
}
