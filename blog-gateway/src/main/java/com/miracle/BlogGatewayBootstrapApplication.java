package com.miracle;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Miracle
 * @date 13:16 2020/6/7
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BlogGatewayBootstrapApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BlogGatewayBootstrapApplication.class).web(WebApplicationType.REACTIVE);
        builder.run(args);
    }
}
