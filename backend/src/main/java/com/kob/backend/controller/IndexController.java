package com.kob.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Steven
 * @create 2023-03-03-13:43
 */
@Controller
@RequestMapping("/pk/")
public class IndexController {

    @RequestMapping("index/")
    public String index() {
        return "pk/index.html";
    }
}
