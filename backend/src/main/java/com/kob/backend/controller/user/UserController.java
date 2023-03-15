package com.kob.backend.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Steven
 * @create 2023-03-14-20:47
 */

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/all/")
    public List<User> getAll() {
        return userMapper.selectList(null);
    }

    @GetMapping("/user/{userId}}/")
    public User getUser(@PathVariable int userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return userMapper.selectOne(queryWrapper);
    }

    @PostMapping("/user/add/password/")
    public String addUser(@RequestBody User user) {
        String password = user.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(password);
        user.setPassword(encodePassword);
        userMapper.insert(user);
        return "Add User Successfully!";
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userMapper.deleteById(id);
        return "Delete Successfully!";
    }
}
