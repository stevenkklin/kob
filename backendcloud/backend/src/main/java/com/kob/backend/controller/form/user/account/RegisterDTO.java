package com.kob.backend.controller.form.user.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Steven
 * @create 2023-03-16-10:08
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("确认密码")
    private String confirmedPassword;

}
