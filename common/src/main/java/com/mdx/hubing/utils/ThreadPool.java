package com.mdx.hubing.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Author: Meng
 * Date: 2023-10-13
 * Desc:
 * 线程池设置最大线程数量公式：
 *  IO密集型：
        线程数 = 核数 * 期望CPU利用率 * 总时间 (CPU计算时间 + 等待时间) / CPU 计算时间
 *      如：4核CPU计算时间是50%，等待时间是50%，期望cpu被100%利用，套公式 4 * 100% * 100% / 50% = 8
 *      如：4核CPU计算时间是10%，等待时间是90%，期望cpu被100%利用，套公式 4 * 100%* 100% / 10%= 40
 *
 *   1.IO密集型经验应用，线程池大小设置为 2N+1 (N为CPU核心数)
 *   2.CPU密集型应用，则线程池大小设置为 N+1
 *
 * IO密集型 和 CPU密集型 简单来说就是看服务器是注重CPU运算还是IO传输；
 * IO密集型：这种方式是较为常见的。如：web应用、RPC调用、数据库连接，只要是涉及到网络，Socket四元组的都属于IO密集型。
 * CPU占用时间怎么知道？如在Linux上运行项目，使用top命令即可实时查看CPU的利用率等信息；
 * 对于CPU密集型：通常采用cpu核心数＋1 能够实现最优的CPU利用率，+1是保证当线程由于页缺失故障(操作系统）或其它原因导致暂停时，额外的这个线程就能顶上去，保证CPU时钟周期不被浪费；
 */
public class ThreadPool {
    private Executor diskPool;
    private Executor socketPool;
    private static volatile ThreadPool pool;

    private ThreadPool() {
        initPool();
    }

    public static ThreadPool create() {
        if (pool == null) {
            synchronized (ThreadPool.class) {
                if(pool == null) {
                    pool = new ThreadPool();
                }
            }
        }
        return pool;
    }

    public void initPool() {
        int threadNum = Runtime.getRuntime().availableProcessors();
        System.out.println("ThreadPool ------> size：" + threadNum);
        socketPool = Executors.newSingleThreadExecutor();
        diskPool = Executors.newFixedThreadPool(threadNum);
    }

    public Executor getSocketPool() {
        return socketPool;
    }

    public Executor getDiskPool() {
        return diskPool;
    }
}
