package com.kob.backend.controller.user.account;

import com.kob.backend.common.util.R;
import com.kob.backend.service.user.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-15-20:15
 */
@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/api/user/account/info/")
    public R getInfo() {
        Map<String, String> map = infoService.getInfo();
        return R.ok("用户信息获取成功").ok(map);
    }

}
