package com.eurekaserver.eurekaserver.thread;

import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @ClassName : MyCallable
 * @Description :
 * @Author : xj
 * @Date: 2020-09-14 17:07
 */
@Data
public class MyCallable implements Callable<Integer> {
    private Integer taskNum;
    public MyCallable(Integer taskNum){
        this.taskNum = taskNum;
    }
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:"+Thread.currentThread().getName() +" 执行:"+taskNum +"  run");
        return taskNum;
    }
}
