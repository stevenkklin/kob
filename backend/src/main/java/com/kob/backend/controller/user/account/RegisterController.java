package com.kob.backend.controller.user.account;

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

    @PostMapping("/user/account/register/")
    public Map<String, String> register(@RequestBody RegisterDTO registerForm) {
        String username = registerForm.getUsername();
        String password = registerForm.getPassword();
        String confirmedPassword = registerForm.getConfirmedPassword();
        return registerService.register(username, password, confirmedPassword);
    }

}
