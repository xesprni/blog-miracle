package com.miracle.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Miracle
 * @date 10:25 2019/6/30
 */
@Data
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -8892874039278251459L;

    private Long pageNum;

    private Long pageSize;

    private Long total;

    List<T> pageData;
}
