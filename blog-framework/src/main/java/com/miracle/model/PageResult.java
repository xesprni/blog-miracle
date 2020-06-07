package com.miracle.model;

import lombok.Data;

import java.util.List;

/**
 * @author Miracle
 * @date 10:25 2019/6/30
 */
@Data
public class PageResult<T> {

    private static final long serialVersionUID = -8892874039278251459L;

    private Integer pageNum;

    private Integer pageSize;

    List<T> pageData;
}
