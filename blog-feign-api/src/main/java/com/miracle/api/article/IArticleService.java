package com.miracle.api.article;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.entity.article.ArticleQueryVO;
import com.miracle.repository.article.entity.ArticleDTO;
import com.miracle.repository.article.entity.ArticleDetailDTO;
import com.miracle.model.ModelResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
    ModelResult<Page<ArticleDTO>> getArticleList(@RequestBody(required = false) ArticleQueryVO articleQueryVO);

    @GetMapping("/getArticleById")
    ModelResult<ArticleDetailDTO> getArticleById(@RequestParam("id") String id);
}
