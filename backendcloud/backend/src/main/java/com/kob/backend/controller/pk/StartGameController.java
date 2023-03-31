package com.kob.backend.controller.pk;

import com.kob.backend.service.pk.StartGameService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author Steven
 * @create 2023-03-28-20:12
 */
@RestController
public class StartGameController {
    @Autowired
    private StartGameService startGameService;

    @PostMapping("/pk/start/game/")
    public String startGame(@RequestParam MultiValueMap<String, String> data) {
        Integer aId = Integer.parseInt(Objects.requireNonNull(data.getFirst("aId")));
        Integer aBotId = Integer.parseInt(Objects.requireNonNull(data.getFirst("aBotId")));
        Integer bId = Integer.parseInt(Objects.requireNonNull(data.getFirst("bId")));
        Integer bBotId = Integer.parseInt(Objects.requireNonNull(data.getFirst("bBotId")));
        System.out.println("success to backend botId" + aBotId + " " + bBotId);
        return startGameService.startGame(aId, aBotId, bId, bBotId);
    }
}
