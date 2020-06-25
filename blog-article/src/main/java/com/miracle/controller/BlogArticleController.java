package com.miracle.controller;

import cn.hutool.core.bean.BeanUtil;
import com.miracle.api.article.IArticleService;
import com.miracle.entity.admin.vo.ArticleDetailVO;
import com.miracle.entity.article.po.ArticleDetailPO;
import com.miracle.entity.article.po.ArticlePO;
import com.miracle.entity.article.vo.ArticleQueryVO;
import com.miracle.model.ModelResult;
import com.miracle.model.ModelResultClient;
import com.miracle.model.PageResult;
import com.miracle.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author Miracle
 * @date 13:32 2020/6/7
 */
@Slf4j
@RestController
public class BlogArticleController implements IArticleService {

    private final ArticleService articleService;


    public BlogArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    @Cacheable(value = "indexCache", key = "#articleQueryVO.pageNum")
    public ModelResult<PageResult<ArticlePO>> getArticleList(@RequestBody @Valid ArticleQueryVO articleQueryVO) {
        PageResult<ArticlePO> result = articleService.getArticleList(articleQueryVO);
        if (Objects.nonNull(result)) {
            return new ModelResultClient<PageResult<ArticlePO>>().success(result);
        }
        return new ModelResultClient<PageResult<ArticlePO>>().fail();
    }

    @Override
    public ModelResult<ArticleDetailPO> getArticleById(@RequestParam("id") String id) {
        return null;
    }

    @Override
    public ModelResult<Boolean> saveArticle(@RequestBody @Valid ArticleDetailVO articleDetailVO) {
        ArticleDetailPO po = BeanUtil.copyProperties(articleDetailVO, ArticleDetailPO.class);
        if (articleService.saveArticle(po) == 1) {
            return new ModelResultClient<Boolean>().success(true);
        }
        return new ModelResultClient<Boolean>().fail();
    }


}
