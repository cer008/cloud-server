package com.eurekaserver.eurekaserver.demo;

public class interrupt {

   /* interrupt()由线程实例调用，给当前线程设置中断状态，标志位置为true
    interrupted() 返回当前线程是否中断，并且重置标志位
    public static boolean interrupted() {
        return currentThread().isInterrupted(true);
    }
    isInterrupted()由线程实例调用，返回是否中断*/
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.interrupt();
        System.out.println("thread - " + thread.isInterrupted());
        boolean interrupted = Thread.interrupted();
        System.out.println("当前线程（main）中断 - " + Thread.currentThread().isInterrupted());
    }


    public static class userThread extends Thread{
        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println(Thread.currentThread().getName());
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
