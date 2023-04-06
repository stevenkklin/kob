package com.kob.backend.controller.user.bot;

import com.kob.backend.common.util.R;
import com.kob.backend.controller.form.user.bot.UpdateDTO;
import com.kob.backend.service.user.bot.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-18-14:20
 */
@RestController
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @PostMapping("/api/user/bot/update")
    public R update(@RequestBody UpdateDTO updateDTO) {
        Map<String, String> map = new HashMap<>();
        map.put("botId", updateDTO.getBotId());
        map.put("title", updateDTO.getTitle());
        map.put("description", updateDTO.getDescription());
        map.put("content", updateDTO.getContent());
        return R.ok(updateService.update(map));
    }

}
