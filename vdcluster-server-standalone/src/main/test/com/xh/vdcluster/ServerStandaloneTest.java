package com.xh.vdcluster;

import com.xh.vdcluster.message.rabbitmq.MessageAdapter;
import com.xh.vdcluster.rpc.ReportService;
import com.xh.vdcluster.rpc.ReportServiceAdapter;
import com.xh.vdcluster.service.MessageService;
import com.xh.vdcluster.service.impl.MessageServiceImpl;
import com.xh.vdcluster.service.impl.ReportServiceImpl;

/**
 * Created by bloom on 2017/7/31.
 */
public class ServerStandaloneTest {
    public static void main(String[] args) {
        try {

            MessageAdapter messageAdapter =  MessageAdapter.getInstance("vdcluster","vdcluster","10.200.8.102",5672,"/");
            messageAdapter.setHostName("10.200.8.102");
            messageAdapter.setPort(5672);
            messageAdapter.setUserName("vdcluster");
            messageAdapter.setPassword("vdcluster");
            messageAdapter.setVirtualHost("/");

            //report服务开启
            MessageService messageService = new MessageServiceImpl();
            ReportService.Iface reportService = new ReportServiceImpl();
            new ReportServiceAdapter(9091, reportService);

//        DetectServiceInAsyncAdapter detectServiceInAsyncAdapter = new DetectServiceInAsyncAdapter("10.200.9.130",9090);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
