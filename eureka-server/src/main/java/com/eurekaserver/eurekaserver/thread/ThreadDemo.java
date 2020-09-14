package com.eurekaserver.eurekaserver.thread;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName : ThreadDemo
 * @Description : 测试线程池
 * @Author : xj
 * @Date: 2020-09-14 16:22
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = ThreadPool.getThreadPoolExecutor();
        for (int i = 0; i < 100; i++) {
            System.out.println("添加第"+i+"个任务");
            threadPoolExecutor.execute(new MyRunnable(i));
            Iterator iterator = threadPoolExecutor.getQueue().iterator();
            while (iterator.hasNext()){
                MyRunnable thread = (MyRunnable) iterator.next();
                System.out.println("列表："+thread.getTaskNum());
            }

//            Future<Integer> submit = threadPoolExecutor.submit(new MyCallable(i));
//            System.out.println(submit.get());
        }
    }
}
