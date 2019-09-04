package org.maple.quartz.listener.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author Mapleins
 * @date 2019-08-11 22:33
 * @description TODO
 */
public class MyJobListener implements JobListener {

    /**
     * @return 监听器的名称
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 在执行前
     * @param jobExecutionContext
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        // context 可以获取上下文
        System.out.println("before");
    }

    /**
     * 执行时被否决
     * @param jobExecutionContext
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        System.out.println("deny");
    }

    /**
     * 执行后
     * @param jobExecutionContext
     * @param e
     */
    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        System.out.println("after");
    }
}
