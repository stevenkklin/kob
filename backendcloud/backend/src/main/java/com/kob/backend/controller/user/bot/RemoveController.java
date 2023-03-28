package com.kob.backend.controller.user.bot;

import com.kob.backend.common.util.R;
import com.kob.backend.controller.form.user.bot.RemoveDTO;
import com.kob.backend.service.user.bot.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-18-13:40
 */
@RestController
public class RemoveController {
    @Autowired
    private RemoveService removeService;

    @PostMapping("/user/bot/remove")
    public R remove(@RequestBody RemoveDTO removeDTO) {
        Map<String, String> params = new HashMap<>();
        params.put("botId", removeDTO.getBotId());
        return R.ok(removeService.remove(params));
    }
}
