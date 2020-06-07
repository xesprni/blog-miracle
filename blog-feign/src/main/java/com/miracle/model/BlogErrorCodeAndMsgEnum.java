package com.miracle.model;

import lombok.Getter;

/**
 * @author Miracle
 * 异常代码枚举类
 */
@Getter
public enum BlogErrorCodeAndMsgEnum {
    /**服务端异常*/
    SERVER_ERROR("500","服务端异常"),
    /**参数校验异常*/
    PARAM_VALIDATE_ERROR("50010","参数校验异常"),
    ARTICLE_SAVE_ERROR("50020","文章保存失败"),
    ARTICLE_EDIT_ERROR("50030","文章编辑失败");
    private String code;
    private String msg;

    BlogErrorCodeAndMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
