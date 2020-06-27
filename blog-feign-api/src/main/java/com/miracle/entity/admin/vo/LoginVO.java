package com.miracle.entity.admin.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Miracle
 * @date 17:47 2020/6/27
 */
@Data
public class LoginVO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String code;

}
