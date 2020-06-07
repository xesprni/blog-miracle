package com.miracle.entity.article;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank
    private String title;

    /**
     * 文章内容
     */
    @NotBlank
    private String content;

    /**
     * 文章提要
     */
    @NotBlank
    private String summary;

    /**
     * 文章类型 关联字典表
     */
    private Integer type;

    /**
     * 作者
     */
    @NotNull
    private String author;

    /**
     * 置顶标识
     */
    private Integer topFlag;


}
