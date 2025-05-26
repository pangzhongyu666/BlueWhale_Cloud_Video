package com.cloud.bluewhale.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RedissonConfig {

    @Value("${redisson.address}")
    private String redissonAddress;

    @Bean
    public RedissonClient redissonClient() {
        // 配置
        Config config = new Config();
        // 地址
        config.useSingleServer().setAddress(redissonAddress);
        // 创建 RedissonClient 对象
        return Redisson.create(config);
  }
}

