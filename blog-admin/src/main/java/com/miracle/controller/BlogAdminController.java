package com.miracle.controller;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.miracle.api.admin.IAdminService;
import com.miracle.api.article.IArticleService;
import com.miracle.entity.admin.vo.ArticleDetailVO;
import com.miracle.entity.admin.vo.LoginVO;
import com.miracle.model.ModelResult;
import com.miracle.model.ModelResultClient;
import com.miracle.service.AuthService;
import com.miracle.utils.RandomValidateCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * @author Miracle
 * @date 8:50 2020/6/25
 */
@Slf4j
@RestController
public class BlogAdminController implements IAdminService {

    @Value("${admin.user}")
    private String user;

    @Value("${admin.pwd}")
    private String pwd;

    private final AuthService authService;

    private final LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(30, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return "";
                }
            });

    private final IArticleService articleService;

    public BlogAdminController(AuthService authService, IArticleService articleService) {
        this.authService = authService;
        this.articleService = articleService;
    }

    @Override
    public ModelResult<Boolean> saveArticle(ArticleDetailVO articleDetailVO) {
        return articleService.saveArticle(articleDetailVO);
    }

    @Override
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            //设置相应类型,告诉浏览器输出的内容为图片
            response.setContentType("image/jpeg");
            //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            //输出验证码图片方法
            randomValidateCode.getRandCode(request, response, cache);
        } catch (Exception e) {
            log.error("获取验证码失败>>>>   ", e);
        }
    }

    @Override
    public ModelResult<String> login(@Valid @RequestBody LoginVO vo) {
        if (vo.getUsername().equals(user) && vo.getPassword().equals(pwd)) {
            String code = cache.getIfPresent(vo.getCode());
            if (StringUtils.isNotBlank(code)) {
                String token = authService.signToken();
                if (StringUtils.isNotBlank(token)) {
                    return new ModelResultClient<String>().success(token);
                }
            }
        }
        return new ModelResultClient<String>().fail();
    }

}
