package org.maple.quartz.first.main;

import org.maple.quartz.first.job.HelloJob;
import org.maple.quartz.first.job.HelloJob3;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author Mapleins
 * @date 2019-08-10 17:38
 * @description TODO
 */
public class HelloSchedulerDemo3 {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(HelloJob3.class)
                .withIdentity("job3", "group3")
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group3")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(1))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);


        scheduler.start();

        Thread.sleep(5000);

        System.out.println("开始暂停");

        scheduler.pauseJob(JobKey.jobKey("job3","group3"));
//        scheduler.pauseJob(JobKey.jobKey("job3"));

        System.out.println("已经停止");

        Thread.sleep(5000);

        System.out.println("开始恢复");
        scheduler.resumeJob(JobKey.jobKey("job3","group3"));
        System.out.println("恢复结束");

//        scheduler.standby();
//        scheduler.start();
//        scheduler.shutdown(true);
        Thread.sleep(5000);
        System.out.println("开始删除");
        scheduler.deleteJob(JobKey.jobKey("job3","group3"));

    }
}
