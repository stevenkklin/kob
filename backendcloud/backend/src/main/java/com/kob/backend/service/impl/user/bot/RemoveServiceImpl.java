package com.kob.backend.service.impl.user.bot;

import com.kob.backend.exception.KOBException;
import com.kob.backend.mapper.BotMapper;
import com.kob.backend.pojo.Bot;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.bot.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-18-13:25
 */
@Service
public class RemoveServiceImpl implements RemoveService {

    @Autowired
    BotMapper botMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int botId = Integer.parseInt(data.get("botId"));
        Bot bot = botMapper.selectById(botId);
        Map<String, String> map = new HashMap<>();

        if (bot == null) {
            throw new KOBException("Bot不存在或已被删除");
        }

        if (!bot.getUserId().equals(user.getId())) {
            throw new KOBException("没有权限删除该Bot");
        }

        botMapper.deleteById(botId);

        map.put("msg", "success");
        return map;
    }
}
