package com.xh.vdcluster.message.emqtt;

import com.xh.vdcluster.message.BasicConsumer;
import com.xh.vdcluster.message.MessageHandler;
import org.fusesource.hawtdispatch.Dispatch;
import org.fusesource.hawtdispatch.DispatchQueue;
import org.fusesource.hawtdispatch.Metrics;
import org.fusesource.hawtdispatch.Task;
import org.fusesource.mqtt.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.fusesource.hawtbuf.Buffer.utf8;

/**
 * Created by bloom on 2017/8/4.
 */
public class MessageAdapter implements MessageHandler {

    private MQTT mqttClient;

    private FutureConnection futureConnection;

    public MessageAdapter(String host, int port) {

        try {
            mqttClient = new MQTT();

            mqttClient.setHost(host, port);

            mqttClient.setDispatchQueue(Dispatch.createQueue("vdcluster"));

            futureConnection = mqttClient.futureConnection();

            Future<Void> f1 = futureConnection.connect();

            f1.await();



        } catch (Exception e) {

        }
    }

    @Override
    public void disconnect() throws Exception{
        Future<Void> f4 = futureConnection.disconnect();
        f4.await();
    }

    @Override
    public void publishMessage(String topic, String message) throws Exception {

        // send the message..
        Future<Void> future = futureConnection.publish(topic, message.getBytes(), QoS.AT_LEAST_ONCE, false);
        future.wait();
    }

    @Override
    public void subscribeMessage(String topic, BasicConsumer basicConsumer) throws Exception {
        Future<byte[]> future = futureConnection.subscribe(new Topic[]{new Topic(utf8(topic), QoS.AT_LEAST_ONCE)});
        byte[] qoses = future.await();
        // We can start future receive..
        Future<Message> receive = futureConnection.receive();
        // Then the receive will get the message.
        Message message = receive.await();
        message.ack();
    }
}
