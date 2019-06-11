package com.sumit.test.practice.restfulwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisConnectivityLocally {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return jedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory((RedisConnectionFactory) jedisConnectionFactory());
		return template;
	}

}
