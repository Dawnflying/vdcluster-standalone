package com.xh.vdcluster.message;

import com.rabbitmq.client.Consumer;

/**
 * Created by bloom on 2017/8/4.
 */
public interface MessageHandler {

    void publishMessage(String topic, String message) throws Exception;

    void subscribeMessage(String topic, BasicConsumer consumer) throws Exception;

    void disconnect() throws Exception;
}
