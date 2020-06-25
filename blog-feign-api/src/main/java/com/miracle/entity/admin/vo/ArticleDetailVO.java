package com.miracle.entity.admin.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Miracle
 * @date 8:04 2020/6/25
 */
@Data
public class ArticleDetailVO implements Serializable {

    private static final long serialVersionUID = -2613507073210794690L;

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
