package com.miracle.api.article;


import com.miracle.entity.article.ArticleDetailPO;
import com.miracle.entity.article.ArticlePO;
import com.miracle.entity.article.ArticleQueryVO;
import com.miracle.model.ModelResult;
import com.miracle.model.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Miracle
 */
@FeignClient(name = "blog-article")
@RequestMapping("/article")
public interface IArticleService {

    /**
     * getArticleList
     *
     * @param articleQueryVO vo
     * @return result
     */
    @PostMapping("/getArticleList")
    ModelResult<PageResult<ArticlePO>> getArticleList(@RequestBody(required = false) ArticleQueryVO articleQueryVO);

    /**
     * getArticleById
     *
     * @param id id
     * @return result
     */
    @GetMapping("/getArticleById")
    ModelResult<ArticleDetailPO> getArticleById(@RequestParam("id") String id);
}
