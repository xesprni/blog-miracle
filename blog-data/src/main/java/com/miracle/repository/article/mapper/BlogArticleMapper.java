package com.miracle.repository.article.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.repository.article.entity.ArticleDTO;
import com.miracle.repository.article.entity.ArticleDetailDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Miracle
 */
@Repository
public interface BlogArticleMapper extends BaseMapper<ArticleDTO> {

    /**
     * query article
     *
     * @param id article id
     * @return article list
     */
    ArticleDetailDTO getArticleById(@Param("id") Long id);
}