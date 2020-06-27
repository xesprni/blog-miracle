package com.miracle.api.admin;

import com.miracle.entity.admin.vo.ArticleDetailVO;
import com.miracle.entity.admin.vo.LoginVO;
import com.miracle.model.ModelResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Miracle
 * @date 8:49 2020/6/25
 */
@FeignClient(name = "blog-admin")
@RequestMapping("/admin")
public interface IAdminService {

    /**
     * saveArticle
     *
     * @param articleDetailVO vo
     * @return boolean
     */
    @PostMapping("/saveArticle")
    ModelResult<Boolean> saveArticle(@RequestBody ArticleDetailVO articleDetailVO);

    /**
     * 获取图片验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getVerify")
    void getVerify(HttpServletRequest request, HttpServletResponse response);

    /**
     * login
     *
     * @param vo vo
     * @return token
     */
    @PostMapping("/login")
    ModelResult<String> login(@Valid @RequestBody LoginVO vo);
}
