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
 * @date 12:24 2020/6/7
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@MapperScan("com.miracle.mapper")
@EnableFeignClients(basePackages = {"com.miracle.api.admin"})
public class BlogArticleBootstrapApplication{

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BlogArticleBootstrapApplication.class).web(WebApplicationType.SERVLET);
        builder.run(args);
    }

}
