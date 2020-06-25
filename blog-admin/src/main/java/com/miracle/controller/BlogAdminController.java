package com.miracle.controller;

import com.miracle.api.admin.IAdminService;
import com.miracle.api.article.IArticleService;
import com.miracle.entity.admin.vo.ArticleDetailVO;
import com.miracle.model.ModelResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miracle
 * @date 8:50 2020/6/25
 */
@RestController
public class BlogAdminController implements IAdminService {

    private final IArticleService articleService;

    public BlogAdminController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ModelResult<Boolean> saveArticle(ArticleDetailVO articleDetailVO) {
        return articleService.saveArticle(articleDetailVO);
    }
}
