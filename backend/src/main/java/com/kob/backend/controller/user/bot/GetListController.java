package com.kob.backend.controller.user.bot;

import com.kob.backend.common.util.R;
import com.kob.backend.service.user.bot.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-18-14:39
 */
@RestController
public class GetListController {
    @Autowired
    private GetListService getListService;

    @GetMapping("/user/bot/getList")
    public R getList(){
        return R.ok().put("userList", getListService.getList());
    }
}
