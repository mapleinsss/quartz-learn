package org.maple.quartz.listener.job;

import org.quartz.*;

import java.time.LocalDateTime;

/**
 * @author Mapleins
 * @date 2019-08-10 17:33
 * @description TODO
 */
public class HelloJob implements Job {

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
        System.out.println("============================");
    }
}
