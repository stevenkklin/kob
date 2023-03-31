package com.kob.backend.service.pk;

import io.swagger.models.auth.In;

/**
 * @author Steven
 * @create 2023-03-28-20:07
 */
public interface StartGameService {
    String startGame(Integer aId, Integer aBotId, Integer bId, Integer bBotId);
}
