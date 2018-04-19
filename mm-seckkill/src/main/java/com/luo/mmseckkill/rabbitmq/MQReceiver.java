package com.luo.mmseckkill.rabbitmq;

import com.luo.mmseckkill.exception.GlobalException;
import com.luo.mmseckkill.result.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class MqReceiver {

    @RabbitListener(queues = MqConfig.DIRECT_QUEUE)
    public void directReceive(String message){
        log.info("receive message:"+message);
    }


    AtomicInteger count = new AtomicInteger(0);

    @RabbitListener(queues = MqConfig.TOPIC_QUEUE1)
    public void topic1Receive(String message){
        int val = count.incrementAndGet();
        if (val != 5){
            throw new GlobalException(CodeMsg.ORDER_NOT_EXIST);
        }
        log.info("receive topic message:"+message);
    }


    @RabbitListener(queues = MqConfig.TOPIC_QUEUE2)
    public void topic2Receive(String message){
        log.info("receive topic message:"+message);
    }

    @RabbitListener(queues=MqConfig.HEADER_QUEUE)
    public void receiveHeaderQueue(byte[] message) {
        log.info("receive header queue message:"+new String(message));
    }
}
