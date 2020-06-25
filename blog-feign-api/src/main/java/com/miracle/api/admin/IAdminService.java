package com.miracle.api.admin;

import com.miracle.entity.admin.vo.ArticleDetailVO;
import com.miracle.model.ModelResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
