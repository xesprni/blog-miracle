package com.miracle.config;

import com.miracle.interceptor.TokenInterceptor;
import com.miracle.service.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Miracle
 * @date 18:15 2020/6/27
 */
@Configuration
public class TokenInterceptorConfig implements WebMvcConfigurer {

    private final AuthService authService;

    public TokenInterceptorConfig(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new TokenInterceptor(authService))
                .addPathPatterns("/admin/saveArticle")
                .excludePathPatterns("/login")
                .excludePathPatterns("/loginPost");
    }
}
