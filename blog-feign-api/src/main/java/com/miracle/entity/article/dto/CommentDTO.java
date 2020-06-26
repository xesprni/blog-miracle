package com.miracle.entity.article.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Miracle
 * @date 18:45 2020/6/26
 */
@Data
public class CommentDTO {
    private Long articleId;
    private Long commentId;
    private Long replyId;
    private String content;
    private Long commenter;
    private Date commentTime;
}
