package com.miracle.service;

import com.miracle.entity.article.dto.ArticleDetailDTO;
import com.miracle.entity.article.po.ArticleDetailPO;
import com.miracle.repository.article.mapper.BlogArticleMapper;
import org.springframework.stereotype.Service;

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

}
