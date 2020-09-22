package com.eurekaserver.eurekaserver.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int STOP = 1 << COUNT_BITS;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = ThreadPool.getThreadPoolExecutor();
        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("添加第" + i + "个任务");

            //runable方式
//            threadPoolExecutor.execute(new MyRunnable(i));
//            Iterator iterator = threadPoolExecutor.getQueue().iterator();
//            threadPoolExecutor.remove(new MyRunnable(i));
//            while (iterator.hasNext()) {
//                MyRunnable thread = (MyRunnable) iterator.next();
//                System.out.println("列表：" + thread.getTaskNum());
//            }

            //callable方式
            //由于submit.get()为阻塞方法,放在循环里,会导致测试时候无法实现多线程,
            // 所以把get方法挪到外面
            futureList.add(threadPoolExecutor.submit(new MyCallable(i)));
            //Future<Integer> submit = threadPoolExecutor.submit(new MyCallable(i));
            //System.out.println(submit.get());
        }
        futureList.forEach(future->{
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }


}
