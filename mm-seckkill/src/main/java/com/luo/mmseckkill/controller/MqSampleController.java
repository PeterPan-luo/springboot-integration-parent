package com.luo.mmseckkill.controller;

import com.luo.mmseckkill.rabbitmq.MqMessage;
import com.luo.mmseckkill.rabbitmq.MqSender;
import com.luo.mmseckkill.result.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MqSampleController {

    @Autowired
    MqSender mqSender;

    @RequestMapping("/directMq")
    public Result<String> directMq(){
        MqMessage<String> msg = new MqMessage<String>();
        msg.setPayload("direct mq test");
        mqSender.directSend(msg);
        return Result.success("success!");
    }

    @RequestMapping("/topicMq")
    public Result<String> topicMq(){
        MqMessage<String> msg = new MqMessage<String>();
        msg.setPayload("topic mq test");
        mqSender.topicSend(msg);
        return Result.success("success!");
    }

    @RequestMapping("/fanoutMq")
    public Result<String> fanoutMq(){
        MqMessage<String> msg = new MqMessage<String>();
        msg.setPayload("fanout mq test");
        mqSender.fandoutSend(msg);
        return Result.success("success!");
    }

    @RequestMapping("/headerMq")
    public Result<String> headerMq(){
        MqMessage<String> msg = new MqMessage<String>();
        msg.setPayload("header mq test");
        mqSender.headerSend(msg);
        return Result.success("success!");
    }
}
