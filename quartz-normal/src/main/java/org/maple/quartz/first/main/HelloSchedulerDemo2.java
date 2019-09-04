package org.maple.quartz.first.main;

import org.maple.quartz.first.job.HelloJob2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author Mapleins
 * @date 2019-08-10 17:38
 * @description TODO
 */
public class HelloSchedulerDemo2 {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 调度器 Scheduler，从工厂中获取
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 任务实例 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob2.class)
                // 任务唯一名称，任务组的的名称
                .withIdentity("job1", "group1")
                .build();

        // 设置任务开始时间
        Date startDate = new Date();
        // 任务开始推迟 3 s
        startDate.setTime(startDate.getTime() + 3000);
        // 设置结束时间
        Date endDate = new Date();
        // 任务结束时间推迟 10 s
        endDate.setTime(endDate.getTime() + 10000);

        // 触发器  Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(1))
                .startNow()
//                .startAt(startDate)
//                .endAt(endDate)
                .build();

        // 让调度器关联任务和触发器
        scheduler.scheduleJob(jobDetail, trigger);

        // 启动调度器
        scheduler.start();

        Thread.sleep(3000);

        System.out.println("~~~~~~~~~~~~~~");
        scheduler.pauseJob(JobKey.jobKey("job1"));

        System.out.println("~~~~~~~~");

    }
}
