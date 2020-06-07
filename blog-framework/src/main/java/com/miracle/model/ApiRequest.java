package com.miracle.model;

import lombok.Setter;

/**
 * @author Miracle
 * @date 08:13 2019/6/20
 */
@Setter
public class ApiRequest {

    private Integer pageNum;

    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }
}
