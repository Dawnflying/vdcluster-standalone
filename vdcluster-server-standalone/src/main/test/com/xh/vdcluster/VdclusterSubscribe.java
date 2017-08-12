package com.xh.vdcluster;

import com.xh.vdcluster.message.BasicConsumer;
import com.xh.vdcluster.message.rabbitmq.MessageAdapter;

/**
 * Created by bloom on 2017/8/8.
 */
public class VdclusterSubscribe {

    public static class ConsumerTest implements BasicConsumer{

        @Override
        public void consume(String message) {

            System.out.println(" ConsumerTest [x] Received '" + message + "'");
            try {

            } finally {
                System.out.println(" ConsumerTest [x] Done");
            }
        }
    }

    public static void main(String[] args) throws Exception{

        MessageAdapter messageAdapter =  MessageAdapter.getInstance("vdcluster","vdcluster","10.200.8.102",5672,"/");


        String topic = "task_queue";

        ConsumerTest test = new ConsumerTest();

        messageAdapter.subscribeMessage(topic,test);

        while(true){

            messageAdapter.publishMessage(topic,"just for funny!!!");
                Thread.sleep(1000);
        }
    }
}
