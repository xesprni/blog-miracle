package com.miracle.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.api.article.IArticleService;
import com.miracle.entity.article.ArticleDTO;
import com.miracle.entity.article.ArticleQueryDTO;
import com.miracle.model.ModelResult;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Miracle
 * @date 13:32 2020/6/7
 */
@RestController
public class BlogArticleController implements IArticleService {

    @Override
    public Mono<ModelResult<Page<ArticleDTO>>> getArticleList(ArticleQueryDTO articleQueryDTO) {
        return null;
    }

}
