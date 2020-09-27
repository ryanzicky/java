package com.example.jvm.volatiletest;

import java.util.Vector;

/**
 * @Author: zhourui
 * @Date: 2020-09-24 13:45
 **/
public class VolatileTest extends Thread {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Vector<Thread> threads = new Vector<>();
        for (int i = 0; i < 100; i++) {
            VolatileTest thread = new VolatileTest();
            threads.add(thread);
            thread.start();
        }

        // 等待子线程全部完成
        for (Thread thread : threads) {
            thread.join();
        }

        // 输出结果，正确结果应该是1000
        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }

//            count++;
            add();
        }
    }

    private static synchronized void add() {
        count++;
    }
}
