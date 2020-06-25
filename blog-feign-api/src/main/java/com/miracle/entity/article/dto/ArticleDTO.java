package com.miracle.entity.article.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Miracle
 * @date 10:17 2019/6/30
 */
@Data
@Accessors(chain = true)
@TableName("blog_article")
public class ArticleDTO implements Serializable {

    private static final long serialVersionUID = -2613507073210794690L;


    /**
     * 文章主键
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章提要
     */
    private String summary;

    /**
     * 文章类型 关联字典表
     */
    private Integer type;

    /**
     * 更新时间
     */
    private Date createTime;

    /**
     * 创建时间
     */
    private Date updateTime;

    /**
     * 作者
     */
    private String author;

    /**
     * 阅读数量
     */
    private Long readCount;

    /**
     * 置顶标识
     */
    private Integer topFlag;

    /**
     * 文章内容
     */
    private String content;

}
