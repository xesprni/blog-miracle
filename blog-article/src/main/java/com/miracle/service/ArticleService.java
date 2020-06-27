package com.miracle.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.constant.UrlConstant;
import com.miracle.entity.article.dto.ArticleDTO;
import com.miracle.entity.article.dto.ArticleDetailDTO;
import com.miracle.entity.article.dto.CommentDTO;
import com.miracle.entity.article.po.ArticleDetailPO;
import com.miracle.entity.article.po.ArticlePO;
import com.miracle.entity.article.po.CommentPO;
import com.miracle.entity.article.po.DailySentencePO;
import com.miracle.entity.article.vo.ArticleQueryVO;
import com.miracle.entity.article.vo.CommentVO;
import com.miracle.model.PageResult;
import com.miracle.model.PageResultConvert;
import com.miracle.repository.article.mapper.BlogArticleMapper;
import com.miracle.utils.WebUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miracle
 * @date 22:10 2020/6/7
 */
@Service
public class ArticleService {

    private final BlogArticleMapper articleMapper;

    public ArticleService(BlogArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public ArticleDetailDTO getArticleById(Long id) {
        return articleMapper.getArticleById(id);
    }

    public Integer saveArticle(ArticleDetailPO po) {
        return articleMapper.saveArticle(po);
    }

    public PageResult<ArticlePO> getArticleList(ArticleQueryVO vo) {
        QueryWrapper<ArticleDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(ArticleDTO.class, tableFieldInfo -> !"content".equals(tableFieldInfo.getColumn())).orderByDesc("top_flag").orderByDesc("update_time");
        return PageResultConvert.convert(articleMapper.selectPage(new Page<>(vo.getPageNum(), vo.getPageSize()), queryWrapper),ArticlePO.class);
    }

    public DailySentencePO getDailySentence() {
        return WebUtils.getResultByUrl(UrlConstant.DAILY_ENGLISH, DailySentencePO.class);
    }

    public List<CommentPO> queryComment(CommentVO vo) {
        return PageResultConvert.convert(articleMapper.queryComment(vo),CommentPO.class);
    }

    public List<ArticlePO> getHotArticle() {
        return PageResultConvert.convert(articleMapper.queryHotArticle(), ArticlePO.class);
    }

    public void addReadCount(String id) {
        articleMapper.addReadCount(id);
    }

    public Integer saveComment(CommentVO vo) {
        return articleMapper.saveComment(vo);
    }

}
