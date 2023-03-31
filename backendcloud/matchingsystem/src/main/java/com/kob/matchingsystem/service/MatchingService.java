package com.kob.matchingsystem.service;

/**
 * @author Steven
 * @create 2023-03-28-14:40
 */
public interface MatchingService {
    String addPlayer(Integer userId, Integer rating, Integer botId);
    String removePlayer(Integer userId);
}
