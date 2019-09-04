package org.maple.quartz.listener.main;

import org.maple.quartz.listener.job.HelloJob;
import org.maple.quartz.listener.listener.MyJobListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

import java.util.Date;

/**
 * @author Mapleins
 * @date 2019-08-10 17:38
 * @description TODO
 */
public class HelloSchedulerDemo {

    public static void main(String[] args) throws SchedulerException {
        // 调度器 Scheduler，从工厂中获取
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 任务实例 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();

        // 触发器  Trigger
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow() // 马上启动或者选择时间
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(3))
                .build();

        // 让调度器关联任务和触发器
        scheduler.scheduleJob(jobDetail, trigger);

        // 创建并注册全局 Job Listener
//        scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());

        // 创建并注册局部 Job Listener
        scheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(JobKey.jobKey("job1","group1")));

        scheduler.start();
    }
}
