package com.kob.backend.controller.user.account;

import com.kob.backend.common.util.R;
import com.kob.backend.controller.form.user.account.RegisterDTO;
import com.kob.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-16-10:11
 */
@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/api/user/account/register/")
    public R register(@RequestBody RegisterDTO registerForm) {
        String username = registerForm.getUsername();
        String password = registerForm.getPassword();
        System.out.println("register" + username + " " + password);
        String confirmedPassword = registerForm.getConfirmedPassword();
        Map<String, String> map = registerService.register(username, password, confirmedPassword);
        return R.ok("注册成功").ok(map);
    }

}
