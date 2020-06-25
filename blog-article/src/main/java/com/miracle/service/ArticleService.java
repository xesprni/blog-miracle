package com.miracle.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.entity.article.dto.ArticleDTO;
import com.miracle.entity.article.dto.ArticleDetailDTO;
import com.miracle.entity.article.po.ArticleDetailPO;
import com.miracle.entity.article.po.ArticlePO;
import com.miracle.entity.article.vo.ArticleQueryVO;
import com.miracle.model.PageResult;
import com.miracle.model.PageResultConvert;
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

    public PageResult<ArticlePO> getArticleList(ArticleQueryVO vo) {
        QueryWrapper<ArticleDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(ArticleDTO.class, tableFieldInfo -> !"content".equals(tableFieldInfo.getColumn())).orderByDesc("top_flag").orderByDesc("update_time");
        return PageResultConvert.convert(articleMapper.selectPage(new Page<>(vo.getPageNum(), vo.getPageSize()), queryWrapper),ArticlePO.class);
    }

}
