package com.example.jvm.singleton;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zhourui
 * @Date: 2020-09-22 14:04
 **/
public class Mgr06 {

    private static volatile Mgr06 INSTANCE = null;

    private Mgr06() {

    }

    ConcurrentHashMap chm = null;

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }
}
