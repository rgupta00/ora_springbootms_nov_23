package com.orderapp.config;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    public static final String ORDER_QUEUE = "order.queue";
    public static final String ORDER_EXCHANGE = "order.exchange";
    public static final String ORDER_ROUTINGKEY = "order.routingkey";

    //1. Define the Queue
    @Bean
    public Queue queue(){
        return new Queue(ORDER_QUEUE);
    }
    //2. Define the Exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(ORDER_EXCHANGE);
    }
    //3. Bind Queue with the exchange
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_ROUTINGKEY);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    //rabbitMQ template
    @Bean
    public AmqpTemplate getAmqpTemplate(ConnectionFactory connectionFactory, MessageConverter converter){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }

}