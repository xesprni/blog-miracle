package com.miracle.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.entity.article.ArticleDTO;
import com.miracle.entity.article.ArticleDetailDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Miracle
 */
@Repository
public interface BlogArticleMapper extends BaseMapper<ArticleDTO> {

    /**
     * query article
     * @param id article id
     * @return article list
     */
    ArticleDetailDTO getArticleDetail(@Param("id") Long id);
}