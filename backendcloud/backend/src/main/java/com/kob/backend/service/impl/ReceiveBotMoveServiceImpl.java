package com.kob.backend.service.impl;

import com.kob.backend.consumer.WebSocketServer;
import com.kob.backend.consumer.utils.Game;
import com.kob.backend.service.pk.ReceiveBotMoveService;
import org.springframework.stereotype.Service;

/**
 * @author Steven
 * @create 2023-03-31-10:11
 */
@Service
public class ReceiveBotMoveServiceImpl implements ReceiveBotMoveService {
    @Override
    public String receiveBotMove(Integer userId, Integer direction) {
        System.out.println("receive bot Move " + userId + " " + direction + " ");
        if (WebSocketServer.users.get(userId) != null) {
            Game game = WebSocketServer.users.get(userId).game;
            if (game != null) {
                if (game.getPlayerA().getId().equals(userId)) {
                        game.setNextStepA(direction);
                } else if (game.getPlayerB().getId().equals(userId)) {
                        game.setNextStepB(direction);
                }
            }
        }

        return "receiveBotSuccess";
    }
}
