package com.kob.backend.controller.form.user.bot;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Steven
 * @create 2023-03-18-13:41
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveDTO {

    private String botId;
}
