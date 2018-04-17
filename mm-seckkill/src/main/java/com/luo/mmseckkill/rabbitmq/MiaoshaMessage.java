package com.luo.mmseckkill.rabbitmq;


import com.luo.mmseckkill.model.MiaoshaUser;
import lombok.Data;

@Data
public class MiaoshaMessage {
	private MiaoshaUser user;
	private long goodsId;

}
