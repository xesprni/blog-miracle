package com.miracle.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author Miracle
 * @date 18:29 2020/6/25
 */
@Configuration
@EnableCaching
public class CaffeineCacheConfig {

    public static final int DEFAULT_MAXSIZE = 500;
    public static final int DEFAULT_TTL = 600;
    public static final int DEFAULT_MINUTE_TTL = 60;
    public static final String INDEX_CACHE_NAME = "indexCache";
    public static final String DICT_CACHE_NAME = "dictCache";


    /**
     * 创建基于Caffeine的Cache Manager
     *
     * @return manager
     */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> caches = new ArrayList<>();
        caches.add(new CaffeineCache(INDEX_CACHE_NAME,
                Caffeine.newBuilder().recordStats()
                        .expireAfterWrite(DEFAULT_TTL, TimeUnit.SECONDS)
                        .maximumSize(DEFAULT_MAXSIZE)
                        .build())
        );
        caches.add(new CaffeineCache(DICT_CACHE_NAME,
                Caffeine.newBuilder().recordStats()
                        .expireAfterWrite(DEFAULT_MINUTE_TTL, TimeUnit.MINUTES)
                        .maximumSize(DEFAULT_MAXSIZE)
                        .build())
        );
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
