package com.kob.backend.controller.form.user.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Steven
 * @create 2023-03-16-10:08
 */
@ApiModel
@Data
public class RegisterForm {

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

    @NotBlank(message = "确认密码不能为空")
    @ApiModelProperty("确认密码")
    private String confirmedPassword;


}
