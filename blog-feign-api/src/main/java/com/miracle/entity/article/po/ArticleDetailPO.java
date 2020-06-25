package com.miracle.entity.article.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Miracle
 * @date 10:17 2019/6/30
 */
@Data
public class ArticleDetailPO implements Serializable {

    private static final long serialVersionUID = -2613507073210794690L;

    private Long articleId;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章提要
     */
    private String summary;

    /**
     * 文章类型 关联字典表
     */
    private Integer type;

    /**
     * 作者
     */
    private String author;

    /**
     * 置顶标识
     */
    private Integer topFlag;


}
