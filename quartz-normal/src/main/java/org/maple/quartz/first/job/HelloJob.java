package org.maple.quartz.first.job;

import org.quartz.*;

import java.time.LocalDateTime;

/**
 * @author Mapleins
 * @date 2019-08-10 17:33
 * @description TODO
 */
// 多次调用 Job 的时候，都会创建新的实例，但是会对 Job 进行持久化，即保存一些数据信息，将 DataMap 中的数据保存
@PersistJobDataAfterExecution
public class HelloJob implements Job {

    public HelloJob() {
        System.out.println("每次开启任务是一个新的 Job 实例");
    }

    // 可以通过 setter 方法获取 DataMap 的键值
    // 如果 job 和 trigger 中的键同名，那么trigger 会覆盖 job 中的内容
    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    // 测试是否有状态
    private Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 执行任务
     *
     * @param context 访问到 Quartz 运行时的环境以及本身的明细数据
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 获取 JobDetail 的内容
        JobKey key = context.getJobDetail().getKey();
        System.out.println("任务名称：" + key.getName());
        System.out.println("组名称：" + key.getGroup());
        System.out.println("类：" + context.getJobDetail().getJobClass());
//        System.out.println("jobDataMap" + context.getJobDetail().getJobDataMap().get("info"));

        // 获取 Trigger 内容  和上面是一样的

        // 获取其他内容
        System.out.println("当前任务的执行时间:" + context.getFireTime());
        System.out.println("下次任务的执行时间:" + context.getNextFireTime());

        System.out.println("通过 Setter 方法获取的 dataMap: " + info);

        // 工作内容
        System.out.println("正在进行数据库备份，备份时间是：" + LocalDateTime.now());

        // 默认是无状态的，即 count 每次都是 1
        ++count;
        // 将 count 存放到 JobDataMap 中
        context.getJobDetail().getJobDataMap().put("count", count);
        System.out.println(count);


        System.out.println("============================");
    }
}
