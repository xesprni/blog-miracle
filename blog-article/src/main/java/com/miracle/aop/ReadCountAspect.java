package com.miracle.aop;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Sets;
import com.miracle.service.ArticleService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Miracle
 * @date 10:51 2020/6/27
 */
@Configuration
@Aspect
public class ReadCountAspect {

    private final ArticleService articleService;

    private final LoadingCache<String, Set<String>> cache = CacheBuilder.newBuilder()
            .maximumSize(1000   )
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Set<String>>() {
                @Override
                public Set<String> load(String key) throws Exception {
                    return Sets.newHashSet();
                }
            });

    public ReadCountAspect(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Pointcut("execution(public * com.miracle.controller.BlogArticleController.getArticleById(..)))")
    public void readCountPoint() {

    }

    @Before(value = "readCountPoint()")
    public void beforeReadCount(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String remoteAddr = request.getRemoteAddr();
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            String id = (String) args[0];
            Set<String> set = cache.getIfPresent(remoteAddr);
            if (set == null) {
                HashSet<String> articleSet = Sets.newHashSet();
                articleSet.add(id);
                articleService.addReadCount(id);
                cache.put(remoteAddr, articleSet);
            } else if (!set.contains(id)) {
                set.add(id);
                articleService.addReadCount(id);
            }
        }

    }
}
