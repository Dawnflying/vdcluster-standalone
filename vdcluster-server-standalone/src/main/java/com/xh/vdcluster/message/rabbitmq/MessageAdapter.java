package com.xh.vdcluster.message.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.xh.vdcluster.message.MessageHandler;

import java.io.IOException;

/**
 * Created by bloom on 2017/7/20.
 */
public class MessageAdapter implements MessageHandler{

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

    private Channel channel;

    /**
     * amqpUrl地址
     */
    private String amqpUrl;

    /**
     * exchange 名称
     */
    private String exchangeName;

    private static MessageAdapter client;

    public static MessageAdapter getInstance() {
        if (client == null)
            client = new MessageAdapter();

        return client;
    }

    private MessageAdapter() {
        try {
            connectionFactory = new ConnectionFactory();
            connectionFactory.setUri(buildAMQPUrl());
            Connection connection = connectionFactory.newConnection();
            this.channel = connection.createChannel();

        } catch (Exception e) {

        }
    }

    private String buildAMQPUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append("amqp://").append(userName).append(":").append(password).append("@").append(hostName + ":" + port + "/" + virtualHost);
        return builder.toString();
    }


    public void publishMessage(String topic ,String message) throws IOException {
        byte[] messageBodyBytes = message.getBytes();
        channel.basicPublish(exchangeName, topic,
                new AMQP.BasicProperties.Builder()
                        .contentType("text/plain")
                        .deliveryMode(2)
                        .priority(1)
                        .userId("bob")
                        .build(),
                messageBodyBytes);
    }

    @Override
    public void subscribeMessage(String topic) {

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
