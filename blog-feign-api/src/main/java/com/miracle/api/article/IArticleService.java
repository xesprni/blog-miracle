package com.miracle.api.article;


import com.miracle.entity.admin.vo.ArticleDetailVO;
import com.miracle.entity.article.po.CommentPO;
import com.miracle.entity.article.vo.CommentVO;
import com.miracle.entity.article.po.ArticleDetailPO;
import com.miracle.entity.article.po.ArticlePO;
import com.miracle.entity.article.po.DailySentencePO;
import com.miracle.entity.article.vo.ArticleQueryVO;
import com.miracle.model.ModelResult;
import com.miracle.model.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * saveArticle
     *
     * @param articleDetailVO vo
     * @return boolean
     */
    @PostMapping("/saveArticle")
    ModelResult<Boolean> saveArticle(@RequestBody ArticleDetailVO articleDetailVO);

    /**
     * get daily english sentence
     *
     * @return daily english sentence
     */
    @GetMapping("/getDailySentence")
    ModelResult<DailySentencePO> getDailySentence();

    /**
     * save comment
     *
     * @param vo vo
     * @return boolean
     */
    @PostMapping("/saveComment")
    ModelResult<Boolean> saveComment(@RequestBody CommentVO vo);

    /**
     * queryComment
     *
     * @param vo vo
     * @return comment
     */
    @PostMapping("/queryComment")
    ModelResult<List<CommentPO>> queryComment(@RequestBody CommentVO vo);

    /**
     * queryComment
     *
     * @return comment
     */
    @GetMapping("/getHotArticle")
    ModelResult<List<ArticlePO>> getHotArticle();

}
