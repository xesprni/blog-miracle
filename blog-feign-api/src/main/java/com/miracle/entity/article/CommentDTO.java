package com.miracle.entity.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author Miracle
 * @date 10:28 2019/6/30
 */
@Data
@Accessors(chain = true)
@TableName("blog_comment")
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    /**
     * 关联文章id
     */
    @NotNull
    private Long articleId;

    /**
     * 回复id
     */
    private Long replyId;

    /**
     * 评论内容
     */
    @NotNull
    private String content;

    /**
     * 评论用户id
     */
    private Long commenter;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 数据状态
     */
    private Integer dataFlag;

}
