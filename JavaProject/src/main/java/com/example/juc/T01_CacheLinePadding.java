package com.example.juc;

/**
 * @Author: zhourui
 * @Date: 2020-09-22 17:01
 **/
public class T01_CacheLinePadding {

    private static class T {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10000000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10000000L; i++) {
                arr[1].x = i;
            }
        });

        long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start) / 1000000);
    }
}
