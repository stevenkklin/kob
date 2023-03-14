package com.kob.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Steven
 * @create 2023-03-03-13:43
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "pk/index.html";
    }
}
