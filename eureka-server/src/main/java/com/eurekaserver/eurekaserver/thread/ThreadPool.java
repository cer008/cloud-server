package com.eurekaserver.eurekaserver.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private static ThreadPoolExecutor threadPoolExecutor;
    //获取cpu核心数
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    /**
     * @return void
     * @throws
     * @Param []
     * @description 初始化线程池
     * @author xj
     * @date 2020/9/14 16:07
     */
    private static void initPool() {
        threadPoolExecutor = new ThreadPoolExecutor(1,
                2,
                10,
                TimeUnit.SECONDS,
                //4种队列
                //1、直接提交队列：设置为SynchronousQueue队列，SynchronousQueue是一个特殊的BlockingQueue，它没有容量，没执行一个插入操作就会阻塞，需要再执行一个删除操作才会被唤醒，反之每一个删除操作也都要等待对应的插入操作。
                //当任务队列为SynchronousQueue，创建的线程数大于maximumPoolSize时，直接执行了拒绝策略抛出异常
                //2、有界的任务队列：有界的任务队列可以使用ArrayBlockingQueue实现
                //使用ArrayBlockingQueue有界任务队列，若有新的任务需要执行时，线程池会创建新的线程，直到创建的线程数量达到corePoolSize时，则会将新的任务加入到等待队列中。若等待队列已满，即超过ArrayBlockingQueue初始化的容量，
                // 则继续创建线程，直到线程数量达到maximumPoolSize设置的最大线程数量，若大于maximumPoolSize，则执行拒绝策略。在这种情况下，线程数量的上限与有界任务队列的状态有直接关系，如果有界队列初始容量较大或者没有达到超负荷的状态，
                // 线程数将一直维持在corePoolSize以下，反之当任务队列已满时，则会以maximumPoolSize为最大线程数上限。
                //3、无界的任务队列：有界任务队列可以使用LinkedBlockingQueue实现
                //4、优先任务队列：优先任务队列通过PriorityBlockingQueue实现
                new ArrayBlockingQueue<Runnable>(3),
                //4种拒绝策略
                //1、AbortPolicy策略：该策略会直接抛出异常，阻止系统正常工作；
                //2、CallerRunsPolicy策略：如果线程池的线程数量达到上限，该策略会把任务队列中的任务放在调用者线程当中运行；
                //3、DiscardOledestPolicy策略：该策略会丢弃任务队列中最老的一个任务，也就是当前任务队列中最先被添加进去的，马上要被执行的那个任务，并尝试再次提交；
                //4、DiscardPolicy策略：该策略会默默丢弃无法处理的任务，不予任何处理。当然使用此策略，业务场景中需允许任务的丢失；
                new ThreadPoolExecutor.AbortPolicy());
    }

    /***
     * @Param []
     * @description 获取线程池
     * @author xj
     * @date 2020/9/14 16:06
     * @return java.util.concurrent.ThreadPoolExecutor
     * @throws
     */
    public static synchronized ThreadPoolExecutor getThreadPoolExecutor() {
        if (null == threadPoolExecutor) {
            initPool();
        }
        return threadPoolExecutor;
    }

}
