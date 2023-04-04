package com.kob.backend.controller.form.record;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Steven
 * @create 2023-04-03-19:18
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRecordListDTO {

    @ApiModelProperty("页号")
    private Integer page;
}
