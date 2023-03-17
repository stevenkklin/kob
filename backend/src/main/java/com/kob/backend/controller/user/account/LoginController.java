package com.kob.backend.controller.user.account;

import com.kob.backend.common.util.R;
import com.kob.backend.controller.form.user.account.LoginDTO;
import com.kob.backend.service.user.account.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-15-16:30
 */
@Api("登录接口")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/account/token/")
    @ApiOperation("登录系统")
    public R getToken(@Valid @RequestBody LoginDTO form) {

        String username = form.getUsername();
        String password = form.getPassword();
        System.out.println("login" + username + " " + password);
        Map<String, String> map = loginService.getToken(username, password);
        return R.ok("登录成功").ok(map);
    }




//    @PostMapping("/user/account/token3/")
//    public String getToken3(@RequestBody User user) {
//        return "success";
//    }
//
//    @GetMapping("/user/account/token4/")
//    public String getToken4() {
//        return "success";
//    }
}
