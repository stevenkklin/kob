package com.kob.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.exception.KOBException;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import com.kob.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-15-20:54
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();
        if (username == null) {
            throw new KOBException("用户名不能为空");
        }
        if (password == null || confirmedPassword == null) {
            throw new KOBException("密码不能为空");
        }

        username = username.trim();
        if (username.length() == 0) {
            throw new KOBException("用户名不能为空");
        }

        if (password.length() == 0 || confirmedPassword.length() == 0) {
            throw new KOBException("密码不能为空");
        }

        if (username.length() > 100) {
            throw new KOBException("用户名长度不能超过100");
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            throw new KOBException("密码长度不能超过100");
        }

        if (!password.equals(confirmedPassword)) {
            throw new KOBException("两次密码长度不一致");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            throw new KOBException("用户名已被使用");
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/35246_lg_70869c519e.jpg";
        User user = new User(null, username, encodedPassword, photo);
        userMapper.insert(user);

        map.put("msg", "success");
        return map;
    }
}
