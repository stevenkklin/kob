package com.kob.matchingsystem;

import com.kob.matchingsystem.service.impl.MatchingServiceImpl;
import com.kob.matchingsystem.service.utils.MatchingPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Steven
 * @create ${YEAR}-${MONTH}-${DAY}-${TIME}
 */
@SpringBootApplication
public class MatchingSystemApplication {
    public static void main(String[] args) {
        MatchingServiceImpl.matchingPool.start();   // 启动匹配线程
        SpringApplication.run(MatchingSystemApplication.class, args);
    }
}