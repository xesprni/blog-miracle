package com.miracle.api.article;


import com.miracle.entity.article.ArticleDTO;
import com.miracle.entity.article.ArticleDetailDTO;
import com.miracle.entity.article.ArticleQueryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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
    Flux<ArticleDTO> getArticleList(@RequestBody(required = false) ArticleQueryDTO articleQueryDTO);

    @GetMapping("/getArticleById")
    Mono<ArticleDetailDTO> getArticleById(@RequestParam("id") String id);
}
