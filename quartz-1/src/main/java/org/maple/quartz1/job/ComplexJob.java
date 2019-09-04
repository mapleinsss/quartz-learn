package org.maple.quartz1.job;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mapleins
 * @date 2019-08-11 22:57
 * @description TODO
 */
@Configuration
@EnableScheduling
public class ComplexJob implements SchedulingConfigurer {

    /**
     * 配置任务
     *
     * @param scheduledTaskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            // 任务
            @Override
            public void run() {
                System.err.println("complex："+LocalDateTime.now());
            }
        }, new Trigger() {
            // 触发器
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 从数据库查出 cron
                String cron = "0/5 * * * * ? ";
                return new CronTrigger(cron).nextExecutionTime(triggerContext);
            }
        });

//        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
//            // 任务
//            @Override
//            public void run() {
//                System.err.println("complex2："+LocalDateTime.now());
//            }
//        }, new Trigger() {
//            // 触发器
//            @Override
//            public Date nextExecutionTime(TriggerContext triggerContext) {
//                // 从数据库查出 cron
//                String cron = "0/5 * * * * ? ";
//                return new CronTrigger(cron).nextExecutionTime(triggerContext);
//            }
//        });
    }
}
