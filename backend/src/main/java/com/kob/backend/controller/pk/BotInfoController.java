package com.kob.backend.controller.pk;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Steven
 * @create 2023-03-03-15:00
 */
@RestController
@RequestMapping("/pk")
public class BotInfoController {

    @RequestMapping("/getbotinfo")
    public Map<String, String> getBotInfo() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "apple");
        map1.put("rating", "2000");
        return map1;
    }
}
