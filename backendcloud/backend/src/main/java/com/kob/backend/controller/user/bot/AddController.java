package com.kob.backend.controller.user.bot;

import com.kob.backend.common.util.R;
import com.kob.backend.controller.form.user.bot.AddDTO;
import com.kob.backend.service.user.bot.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-18-10:56
 */
@RestController
public class AddController {
    @Autowired
    private AddService addService;

    @PostMapping("/api/user/bot/add/")
    public R add(@RequestBody AddDTO addDTO) {
        Map<String, String> map = new HashMap<>();
        map.put("description", addDTO.getDescription());
        map.put("title", addDTO.getTitle());
        map.put("content", addDTO.getContent());

        return R.ok(addService.add(map));
    }
}
