package com.luo.mmseckkill.rabbitmq;

import com.luo.mmseckkill.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MqSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendMiaoshaMessage(MiaoshaMessage mm) {
        String msg = RedisService.beanToString(mm);
        log.info("send message:"+msg);
        amqpTemplate.convertAndSend(MqConfig.MIAOSHA_QUEUE, msg);
    }

    public void directSend(MqMessage message){
        String msg = RedisService.beanToString(message);
		log.info("send message:"+msg);
		amqpTemplate.convertAndSend(MqConfig.DIRECT_QUEUE, msg);
    }

    public void topicSend(MqMessage message){
        String msg = RedisService.beanToString(message);
        log.info("send topic message:"+msg);
        amqpTemplate.convertAndSend(MqConfig.TOPIC_EXCHANGE,"topic.key1", msg+"1");
        amqpTemplate.convertAndSend(MqConfig.TOPIC_EXCHANGE,"topic.key2", msg+"2");
    }

    public void fandoutSend(MqMessage message){
        String msg = RedisService.beanToString(message);
        log.info("send fanout message:"+msg);
        amqpTemplate.convertAndSend(MqConfig.FANOUT_EXCHANGE, "",msg);
    }

    public void headerSend(MqMessage message){
        String msg = RedisService.beanToString(message);
        log.info("send header message:"+msg);
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header1", "value1");
		properties.setHeader("header2", "value2");
        Message obj = new Message(msg.getBytes(), properties);
        amqpTemplate.convertAndSend(MqConfig.HEAD_EXCHANGE, "",obj);
    }



}
