package com.xh.vdcluster.message.rabbitmq;

import com.rabbitmq.client.*;
import com.xh.vdcluster.message.BasicConsumer;
import com.xh.vdcluster.message.MessageHandler;
import io.netty.channel.ChannelFuture;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bloom on 2017/7/20.
 */
public class MessageAdapter implements MessageHandler {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 主机名
     */
    private String hostName;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 虚拟主机
     */
    private String virtualHost;

    private ConnectionFactory connectionFactory;

    /**
     * 发送消息的通道
     */
    private Map<String, Channel> sendChannelMap;

    /**
     * 接收消息的通道
     */
    private Map<String, Channel> receiveChannelMap;

    /**
     * amqpUrl地址
     */
    private String amqpUrl;

    /**
     * exchange 名称
     */
    private static final String exchangeName = "";

    private static MessageAdapter client;

    public static MessageAdapter getInstance(String username,String password,String hostname,int port,String virtualHost) {


        if (client == null)
            client = new MessageAdapter(username,password,hostname,port,"");

        return client;
    }

    private MessageAdapter(String username,String password,String hostname,int port,String virtualHost) {
        this.userName = username;
        this.password = password;
        this.hostName = hostname;
        this.port = port;
        this.virtualHost = virtualHost;
        try {
            connectionFactory = new ConnectionFactory();
            connectionFactory.setUri(buildAMQPUrl());
            this.sendChannelMap = new ConcurrentHashMap<>();
            this.receiveChannelMap = new ConcurrentHashMap<>();

        } catch (Exception e) {

        }
    }

    private MessageAdapter() {
        try {
            connectionFactory = new ConnectionFactory();
            connectionFactory.setUri(buildAMQPUrl());
            this.sendChannelMap = new ConcurrentHashMap<>();
            this.receiveChannelMap = new ConcurrentHashMap<>();

        } catch (Exception e) {

        }
    }

    private String buildAMQPUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append("amqp://").append(userName).append(":").append(password).append("@").append(hostName + ":" + port);
        return builder.toString();
    }


    /**
     * 发布消息，如果通道已经存在直接发送，如果通道不存在，创建新的通道以发布消息。
     *
     * @param topic   需要发布的主题
     * @param message 发布的消息内容
     * @throws Exception
     */
    public void publishMessage(String topic, String message) throws Exception {
        byte[] messageBodyBytes = message.getBytes();
        Channel channel = null;
        if (sendChannelMap.containsKey(topic)) {
            channel = sendChannelMap.get(topic);
        } else {
            Channel newChannel = connectionFactory.newConnection().createChannel();
            sendChannelMap.put(topic, newChannel);
            channel = newChannel;
        }

        channel.queueDeclare(topic, true, false, false, null);
        channel.basicPublish(exchangeName, topic, MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes);
    }

    /**
     * 订阅消息
     *
     * @param topic
     */
    @Override
    public void subscribeMessage(String topic, BasicConsumer consumer) throws Exception {
        Channel channel = null;
        if (receiveChannelMap.containsKey(topic)) {
            channel = receiveChannelMap.get(topic);
        } else {
            channel = connectionFactory.newConnection().createChannel();
            receiveChannelMap.put(topic, channel);
        }
        final Channel finalChannel = channel;
        finalChannel.queueDeclare(topic, true, false, false, null);
        Consumer defaultConsumer =  new DefaultConsumer(finalChannel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {


                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received '" + message + "'");
                try {
                    consumer.consume(message);
                } finally {
                    System.out.println(" [x] Done");
                    finalChannel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        channel.basicConsume(topic, false, defaultConsumer);
    }


    @Override
    public void disconnect() throws Exception {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }
}
