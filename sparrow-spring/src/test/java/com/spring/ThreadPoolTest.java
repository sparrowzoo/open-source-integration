package com.spring;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by harry on 17/3/2.
 * //-Xms1M -Xmx6M -Xmn1M -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/ -XX:+PrintGCDetails
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
            1,
            5L,
            TimeUnit.DAYS.MINUTES,
            workQueue);


        while (true) {
            System.out.println(workQueue.size());
            threadPoolExecutor.execute(new Runnable() {
                public void run() {
                    System.out.println("1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
    }
}
