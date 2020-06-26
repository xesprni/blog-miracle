package com.miracle.entity.article.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Miracle
 * @date 18:45 2020/6/26
 */
@Data
public class CommentPO {
    private Long commentId;
    private Long articleId;
    private Long replyId;
    private String content;
    private Long commenter;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;
}
