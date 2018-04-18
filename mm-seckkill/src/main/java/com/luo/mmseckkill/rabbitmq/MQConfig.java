package com.luo.mmseckkill.rabbitmq;

import com.google.common.collect.Maps;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class MqConfig {

    public static final String MIAOSHA_QUEUE = "miaosha.queue";


    public static final String DIRECT_QUEUE = "directQueue";

    public static final String TOPIC_QUEUE1 = "topic.queue1";
    public static final String TOPIC_QUEUE2 = "topic.queue2";
    public static final String TOPIC_EXCHANGE = "topicExchage";

    public static final String FANOUT_EXCHANGE = "fanoutxchage";


    public static final String HEAD_EXCHANGE = "headexchage";
    public static final String HEADER_QUEUE = "header.queue";

    /**
     * 秒杀队列
     * @return
     */
    @Bean
    public Queue miaoshaQueue(){
        return new Queue(MqConfig.MIAOSHA_QUEUE, true);
    }

    /**
     * Direct模式 交换机Exchange
     * @return
     */
    @Bean
    public Queue directQueue(){
        return new Queue(MqConfig.DIRECT_QUEUE,true);
    }

    /**
     * Topic模式 交换机Exchange
     * */
    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE1,true);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE2,true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.key1");
    }
    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.#");
    }


    /**
     * Fanout模式 交换机Exchange
     **/
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(MqConfig.FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fandoutBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fandoutBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(fanoutExchange());
    }

    /**
     * Header模式 交换机Exchange
     * @return
     */
    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange(MqConfig.HEAD_EXCHANGE);
    }

    @Bean
    public Queue headerQueue1() {
        return new Queue(HEADER_QUEUE, true);
    }

    @Bean
    public Binding headerBinding(){
        Map<String, Object> headMap = Maps.newHashMap();
        headMap.put("header1", "value1");
        headMap.put("header2", "value2");
        return BindingBuilder.bind(headerQueue1()).to(headersExchange()).whereAll(headMap).match();
    }
}
