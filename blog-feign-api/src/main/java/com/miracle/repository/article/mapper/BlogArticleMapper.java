package com.miracle.repository.article.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.entity.article.dto.ArticleDTO;
import com.miracle.entity.article.dto.ArticleDetailDTO;
import com.miracle.entity.article.dto.CommentDTO;
import com.miracle.entity.article.po.ArticleDetailPO;
import com.miracle.entity.article.vo.CommentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * save article
     *
     * @param po po
     * @return affective lines
     */
    Integer saveArticle(@Param("po") ArticleDetailPO po);

    /**
     * queryComment
     *
     * @param vo vo
     * @return commentList
     */
    List<CommentDTO> queryComment(@Param("vo") CommentVO vo);

    /**
     * queryHotArticle
     *
     * @return articles
     */
    List<ArticleDTO> queryHotArticle();

    /**
     * addReadCount
     *
     * @param id id
     * @return affective lines
     */
    Long addReadCount(@Param("id") String id);

    /**
     * save Comment
     * @param vo vo
     * @return lines
     */
    Integer saveComment(@Param("vo") CommentVO vo);
}