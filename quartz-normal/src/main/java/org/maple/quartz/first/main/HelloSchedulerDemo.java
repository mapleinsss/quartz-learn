package org.maple.quartz.first.main;

import org.maple.quartz.first.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

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
                // 任务唯一名称，任务组的的名称
                .withIdentity("job1", "group1")
                // 可以传递任何能序列化的数据对象
                .usingJobData("info","附带信息")
                .usingJobData("count",0)
                .build();

        System.out.println("name: " +jobDetail.getKey().getName());
        System.out.println("group: " +jobDetail.getKey().getGroup());
        System.out.println("class: " +jobDetail.getKey().getClass());
        System.out.println("jobDataMap: " +jobDetail.getJobDataMap().get("info"));

        // 触发器  Trigger
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                // 使用 simpleSchedule ，每 5 秒执行一次
                .startNow() // 马上启动或者选择时间
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(5))
                .build();

        // 让调度器关联任务和触发器
        Date date = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("调度器的开始时间是：" + date);

        // 启动调度器
        scheduler.start();
        // 挂起
        scheduler.standby();
        // 重新启动
        scheduler.start();
        // 关闭 ,关闭后不能重启 ,true 所有 job 完成之后关闭， false 直接关闭
        scheduler.shutdown(true);
    }
}
