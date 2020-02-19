package com.example.demo.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

    /**
     * create RabbitMQ
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/kavito");//JVM name
        factory.setUsername("kavito");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        return connection;
    }

}
