package com.miracle.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Miracle
 * @date 20:28 2019/6/18
 */
@Data
public class ModelResult<T> implements Serializable {

    private static final long serialVersionUID = 6347031911238666626L;

    private boolean flag;

    private String code;

    private String msg;

    private T data;

}
