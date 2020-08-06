package com.eurekaserver.eurekaserver.demo;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class forkjoin {
    private static class BuildArray{
        public static  final int ARRAY_LENGTH = 4000;
        public static int[] buildArray(){
            Random random = new Random();
            int[] result = new int[ARRAY_LENGTH];
            for (int i = 0; i < ARRAY_LENGTH; i++) {
                result[i] = random.nextInt(ARRAY_LENGTH *4);
            }
            return result;
        }
    }

    private static class MyTask extends RecursiveTask<Integer>{
        private static final int THRESHOLD = BuildArray.ARRAY_LENGTH/10;
        private int[] source;//实际统计数据
        private int fromIndex;//开始下标
        private int toIndex;//统计到哪里结束的下标

        public MyTask(int[] source,int fromIndex,int toIndex){
            this.source = source;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }
        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Integer compute() {
            //小于阈值,拆分为最细,计算
            if(toIndex - fromIndex < 200){
                AtomicInteger count = new AtomicInteger();
                for (int i = fromIndex; i < toIndex - 1; i++) {
                    count.getAndSet(source[i]);
                }
                return count.get();
            }else{//大于阈值,递归拆分
                int mid = (fromIndex + toIndex) / 2;
                MyTask left = new MyTask(source,fromIndex,mid);
                MyTask right = new MyTask(source,mid+1,toIndex);
                invokeAll(left,right);
                return left.join()+right.join();
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int[] source = BuildArray.buildArray();
        MyTask myTask = new MyTask(source, 1, 2000);
        Integer invoke = forkJoinPool.invoke(myTask);
        System.out.println(invoke);
    }
}
