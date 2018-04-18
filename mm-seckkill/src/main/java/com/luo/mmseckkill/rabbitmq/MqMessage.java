package com.luo.mmseckkill.rabbitmq;

import lombok.Data;

@Data
public class MqMessage<T> {

    private String header;

    private T payload;

}
