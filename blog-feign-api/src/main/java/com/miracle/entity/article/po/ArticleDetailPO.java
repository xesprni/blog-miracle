package com.miracle.entity.article.po;

import com.miracle.annotation.Dict;
import com.miracle.annotation.DictItem;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Miracle
 * @date 10:17 2019/6/30
 */
@Data
@Dict({@DictItem(attr = "type",item = "ARTICLE_TYPE")})
public class ArticleDetailPO implements Serializable {

    private static final long serialVersionUID = -2613507073210794690L;

    /**
     * 文章主键
     */
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
     * 大纲
     */
    private String summary;


    private String typeName;


}
