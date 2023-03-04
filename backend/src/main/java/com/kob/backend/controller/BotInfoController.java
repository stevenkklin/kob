package com.kob.backend.controller;

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
    public List<Map<String, String>> getBotInfo() {
        List<Map<String, String>> list = new LinkedList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("linchao", "1");
        map1.put("steven", "2");
        Map<String, String> map2 = new HashMap<>();
        map2.put("steven", "3");
        map2.put("linda", "4");
        list.add(map1);
        list.add(map2);
        return list;
    }
}
