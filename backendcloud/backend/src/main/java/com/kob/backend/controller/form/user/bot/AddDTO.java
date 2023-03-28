package com.kob.backend.controller.form.user.bot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Steven
 * @create 2023-03-18-10:58
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDTO {


    private String title;
    private String description;
    private String content;



}
