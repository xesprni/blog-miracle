package com.miracle.entity.article.vo;

import com.miracle.model.ApiRequest;
import lombok.Data;

/**
 * @author Miracle
 * @date 22:30 2020/6/11
 */
@Data
public class ArticleQueryVO extends ApiRequest {

    private String id;

    private int type;

}
