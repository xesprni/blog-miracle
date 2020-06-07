package com.miracle.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Miracle
 * @date 20:27 2019/6/18
 */
@Data
public class ModelResultClient<T> implements Serializable {

    private static final long serialVersionUID = 68993235967697626L;

    private ModelResult<T> data;

    public ModelResult<T> success(T t) {
        ModelResult<T> result = new ModelResult<>();
        result.setFlag(true);
        result.setData(t);
        return result;
    }

    public ModelResult<T> success(String code,String msg) {
        ModelResult<T> result = new ModelResult<>();
        result.setFlag(true);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public ModelResult<T> fail(String code,String msg) {
        ModelResult<T> result = new ModelResult<>();
        result.setFlag(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public ModelResult<T> fail() {
        return this.fail("-1", null);
    }

    public ModelResult<T> fail(String code) {
        return this.fail(code, null);
    }

}
