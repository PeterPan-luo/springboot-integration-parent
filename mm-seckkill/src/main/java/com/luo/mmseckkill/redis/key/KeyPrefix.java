package com.luo.mmseckkill.redis.key;

public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
