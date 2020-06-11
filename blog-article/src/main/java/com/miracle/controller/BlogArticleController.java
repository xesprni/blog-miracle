package com.miracle.controller;

import com.miracle.api.article.IArticleService;
import com.miracle.entity.article.ArticleDetailPO;
import com.miracle.entity.article.ArticlePO;
import com.miracle.entity.article.ArticleQueryVO;
import com.miracle.model.ModelResult;
import com.miracle.model.PageResult;
import com.miracle.service.ArticleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Miracle
 * @date 13:32 2020/6/7
 */
@RestController
public class BlogArticleController implements IArticleService {

    private final ArticleService articleService;

    public BlogArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ModelResult<PageResult<ArticlePO>> getArticleList(@RequestBody @Valid ArticleQueryVO articleQueryVO) {
        return null;
    }

    @Override
    public ModelResult<ArticleDetailPO> getArticleById(@RequestParam("id") String id) {
        return null;
    }


}
