package com.miracle.entity.article.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Miracle
 * @date 11:21 2020/6/26
 */
@Data
public class DailySentencePO {

    private Long sid;

    private String tts;

    private String content;

    private String note;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateline;

}
