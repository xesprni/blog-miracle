package com.miracle.controller;

import cn.hutool.core.bean.BeanUtil;
import com.miracle.api.article.IArticleService;
import com.miracle.entity.admin.vo.ArticleDetailVO;
import com.miracle.entity.article.dto.ArticleDetailDTO;
import com.miracle.entity.article.po.ArticleDetailPO;
import com.miracle.entity.article.po.ArticlePO;
import com.miracle.entity.article.po.CommentPO;
import com.miracle.entity.article.po.DailySentencePO;
import com.miracle.entity.article.vo.ArticleQueryVO;
import com.miracle.entity.article.vo.CommentVO;
import com.miracle.model.ModelResult;
import com.miracle.model.ModelResultClient;
import com.miracle.model.PageResult;
import com.miracle.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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
    @Cacheable(value = "indexCache", key = "#articleQueryVO.pageNum + #articleQueryVO.type")
    public ModelResult<PageResult<ArticlePO>> getArticleList(@RequestBody @Valid ArticleQueryVO articleQueryVO) {
        PageResult<ArticlePO> result = articleService.getArticleList(articleQueryVO);
        if (Objects.nonNull(result)) {
            return new ModelResultClient<PageResult<ArticlePO>>().success(result);
        }
        return new ModelResultClient<PageResult<ArticlePO>>().fail();
    }

    @Override
    public ModelResult<ArticleDetailPO> getArticleById(@RequestParam("id") String id) {
        if (!StringUtils.isNumeric(id)) {
            return new ModelResultClient<ArticleDetailPO>().fail();
        }
        ArticleDetailDTO article = articleService.getArticleById(Long.valueOf(id));
        return new ModelResultClient<ArticleDetailPO>().success(BeanUtil.copyProperties(article, ArticleDetailPO.class));
    }

    @Override
    public ModelResult<Boolean> saveArticle(@RequestBody @Valid ArticleDetailVO articleDetailVO) {
        ArticleDetailPO po = BeanUtil.copyProperties(articleDetailVO, ArticleDetailPO.class);
        if (articleService.saveArticle(po) == 1) {
            return new ModelResultClient<Boolean>().success(true);
        }
        return new ModelResultClient<Boolean>().fail();
    }

    @Override
    @Cacheable(value = "dictCache", key = "#root.methodName")
    public ModelResult<DailySentencePO> getDailySentence() {
        DailySentencePO dailySentence = articleService.getDailySentence();
        if (Objects.nonNull(dailySentence)) {
            return new ModelResultClient<DailySentencePO>().success(dailySentence);
        }
        return new ModelResultClient<DailySentencePO>().fail();
    }

    @Override
    public ModelResult<Boolean> saveComment(@RequestBody CommentVO vo) {

        return null;
    }

    @Override
    public ModelResult<List<CommentPO>> queryComment(@RequestBody CommentVO vo) {
        if (vo.getArticleId()==null) {
            return new ModelResultClient<List<CommentPO>>().fail();
        }
        List<CommentPO> lists = articleService.queryComment(vo);
        if (lists==null) {
            lists = new ArrayList<>();
        }
        return new ModelResultClient<List<CommentPO>>().success(lists);
    }

    @Override
    @Cacheable(value = "dictCache", key = "#root.methodName")
    public ModelResult<List<ArticlePO>> getHotArticle() {
        return new ModelResultClient<List<ArticlePO>>().success(articleService.getHotArticle());
    }


}
