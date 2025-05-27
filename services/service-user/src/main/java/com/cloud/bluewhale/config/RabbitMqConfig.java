package com.cloud.bluewhale.config;

import feign.Retryer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
	@Bean
	Retryer retryer(){
		return new Retryer.Default();
	}

	@Bean
	public MessageConverter messageConverter() {
		//定义消息转换器，将消息对象序列化为JSON格式
		Jackson2JsonMessageConverter jjmc = new Jackson2JsonMessageConverter();
		//配置自动创建消息id，用于标识消息的唯一性
		//jjmc.setCreateMessageIds(true);
		return jjmc;
	}

}
