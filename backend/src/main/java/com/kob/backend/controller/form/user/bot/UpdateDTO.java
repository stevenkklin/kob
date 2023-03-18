package com.kob.backend.controller.form.user.bot;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Steven
 * @create 2023-03-18-14:22
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDTO {

    private String botId;
    private String title;
    private String description;
    private String content;

}
