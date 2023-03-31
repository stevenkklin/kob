package com.kob.botrunningsystem.service.impl;

import com.kob.botrunningsystem.service.BotRunningService;
import com.kob.botrunningsystem.service.impl.util.BotPool;
import org.springframework.stereotype.Service;

/**
 * @author Steven
 * @create 2023-03-29-15:28
 */
@Service
public class BotRunningServiceImpl implements BotRunningService {
    public static final BotPool botPool = new BotPool();


    @Override
    public String addBot(Integer userId, String botCode, String input) {
        System.out.println("addBot " + userId + " " + botCode + " " + input);
        botPool.addBot(userId, botCode, input);
        return "add bot success";
    }

}
