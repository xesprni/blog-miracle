package com.miracle.entity.article;

import com.miracle.model.ApiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Miracle
 * @date 15:39 6/30/2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleQueryDTO extends ApiRequest {

    private Long id;

    private Integer type;

    private String title;

}
