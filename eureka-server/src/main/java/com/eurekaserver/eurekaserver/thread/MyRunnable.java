package com.eurekaserver.eurekaserver.thread;

import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @ClassName : MyCallback
 * @Description :
 * @Author : xj
 * @Date: 2020-09-14 16:50
 */
@Data
public class MyRunnable implements Runnable {
    private Integer taskNum;
    public MyRunnable(Integer taskNum){
        this.taskNum = taskNum;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:"+Thread.currentThread().getName() +" 执行:"+taskNum +"  run");
    }

//    /**
//     * Computes a result, or throws an exception if unable to do so.
//     *
//     * @return computed result
//     * @throws Exception if unable to compute a result
//     */
//    @Override
//    public Integer call() throws Exception {
//        Thread.sleep(1000);
//        System.out.println("ThreadName:"+Thread.currentThread().getName());
//        return taskNum;
//    }
}
