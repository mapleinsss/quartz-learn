package org.maple.quartz.first.job;

import org.quartz.*;

import java.time.LocalDateTime;

/**
 * @author Mapleins
 * @date 2019-08-10 17:33
 * @description TODO
 */
public class HelloJob3 implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("============================");
    }
}
