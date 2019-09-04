package org.maple.quartz1.job;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @author Mapleins
 * @date 2019-08-11 22:52
 * @description TODO
 */
@Configuration
@EnableScheduling // 开启任务调度
public class SimpleJob {

    @Scheduled(cron = "0/5 * * * * ? ")
    public void run() {
        // 任务
        System.out.println(LocalDateTime.now());
    }
}
