package com.miracle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Miracle
 * @date 7:56 2020/6/25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@MapperScan("com.miracle.repository")
@EnableFeignClients(basePackages = {"com.miracle.api.article"})
public class BlogAdminBootstrapApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BlogAdminBootstrapApplication.class).web(WebApplicationType.SERVLET);
        builder.run(args);
    }

}
