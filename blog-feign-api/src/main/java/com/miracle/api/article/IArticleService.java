package com.miracle.api.article;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.entity.article.ArticleDTO;
import com.miracle.entity.article.ArticleQueryDTO;
import com.miracle.model.ModelResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

/**
 * @author Miracle
 */
@FeignClient(name = "blog-article")
@RequestMapping("/article")
public interface IArticleService{

    /**
     * get article list
     * @param articleQueryDTO query article
     * @return list
     */
    @PostMapping("/getArticleList")
    Mono<ModelResult<Page<ArticleDTO>>> getArticleList(@RequestBody(required = false) ArticleQueryDTO articleQueryDTO);


}
