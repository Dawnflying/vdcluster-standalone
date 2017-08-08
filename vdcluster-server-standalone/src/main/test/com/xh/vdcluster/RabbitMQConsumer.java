package com.xh.vdcluster;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by bloom on 2017/8/7.
 */
public class RabbitMQConsumer {
    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(buildAMQPUrl());
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1);

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        boolean autoAck = false;
        channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);
    }

    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private static String buildAMQPUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append("amqp://").append("vdcluster").append(":").append("vdcluster").append("@").append( "10.200.8.102:5672");
        return builder.toString();
    }
}
