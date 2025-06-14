package com.cloud.bluewhale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 搜索服务启动类
 * @author shigc
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableAsync
@EnableFeignClients(basePackages = "com.cloud.bluewhale.clients")
public class SearchApplication {
    public static void main(String[]args){
        SpringApplication.run(SearchApplication.class);
    }
}


