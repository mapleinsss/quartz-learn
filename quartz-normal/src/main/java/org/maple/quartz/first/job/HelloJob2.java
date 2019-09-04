package org.maple.quartz.first.job;

import org.quartz.*;

import java.time.LocalDateTime;

/**
 * @author Mapleins
 * @date 2019-08-10 17:33
 * @description TODO
 */
public class HelloJob2 implements Job {

    /**
     * 执行任务
     *
     * @param context 访问到 Quartz 运行时的环境以及本身的明细数据
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        // 工作内容
        System.out.println("正在进行数据库备份，备份时间是：" + LocalDateTime.now());

        // 获取 JobKey、startTime、endTime
//        Trigger trigger = context.getTrigger();
//        System.out.println(trigger.getJobKey().getName());
//        System.out.println(trigger.getJobKey().getGroup());
//        System.out.println(trigger.getStartTime());
//        System.out.println(trigger.getEndTime());

        System.out.println("============================");
    }
}
