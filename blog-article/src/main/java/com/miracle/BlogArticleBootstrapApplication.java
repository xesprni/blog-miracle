package com.miracle;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Miracle
 * @date 12:24 2020/6/7
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BlogArticleBootstrapApplication{

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BlogArticleBootstrapApplication.class).web(WebApplicationType.REACTIVE);
        builder.run(args);
    }

}
