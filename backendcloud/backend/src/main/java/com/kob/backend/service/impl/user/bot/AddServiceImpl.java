package com.kob.backend.service.impl.user.bot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.exception.KOBException;
import com.kob.backend.mapper.BotMapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.Bot;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.bot.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-18-10:22
 */
@Service
public class AddServiceImpl implements AddService {

    @Autowired
    BotMapper botMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        String title = data.get("title");
        String description = data.get("description");
        String content = data.get("content");

        Map<String, String> map = new HashMap<>();

        if (title == null || title.length() == 0) {
            throw new KOBException("标题不能为空");
        }

        if (title.length() > 100) {
            throw new KOBException("标题长度不能大于100");
        }

        if (description == null || description.length() == 0) {
            description = "这个用户很懒， 什么也没留下~";
        }

        if (description.length() > 300 ) {
            throw new KOBException("Bot描述长度不能大于300");
        }

        if (content == null || content.length() == 0) {
            throw new KOBException("代码不能为空");
        }

        if (content.length() > 10000) {
            throw new KOBException("代码长度不能超过10000");
        }

        QueryWrapper<Bot> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getId());
        if (botMapper.selectCount(queryWrapper) >= 10) {
            throw new KOBException("Bot数量不能超过10个!");
        }

        Date now = new Date();
        Bot bot = new Bot(null, user.getId(), title, description, content, now, now);

        botMapper.insert(bot);
        map.put("msg", "success");

        return map;
    }
}
