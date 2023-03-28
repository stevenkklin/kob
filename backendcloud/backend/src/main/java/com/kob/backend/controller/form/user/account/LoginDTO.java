package com.kob.backend.controller.form.user.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Steven
 * @create 2023-03-15-18:15
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

}

