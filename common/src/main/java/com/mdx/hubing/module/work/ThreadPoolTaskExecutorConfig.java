package com.mdx.hubing.module.work;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author: Meng
 * Date: 2023-08-21
 * Desc:
 */

//@Configuration
//@EnableAsync // 开启异步配置
public class ThreadPoolTaskExecutorConfig {
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(10);
        //设置最大线程数
        executor.setMaxPoolSize(20);
        //缓冲队列200：用来缓冲执行任务的队列
        executor.setQueueCapacity(200);
        //线程活路时间 60 秒
        executor.setKeepAliveSeconds(60);
        //线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
        executor.setThreadNamePrefix("taskExecutor-");
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
