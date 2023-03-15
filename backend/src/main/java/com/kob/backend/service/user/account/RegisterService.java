package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * @author Steven
 * @create 2023-03-15-16:10
 */
public interface RegisterService {
    Map<String, String> register(String username, String password, String confirmedPassword);
}
