package com.example.jvm;

/**
 * @Author: zhourui
 * @Date: 2020-09-24 09:49
 **/
public class TestSync {

    synchronized void m() {

    }

    void n() {
        synchronized (this) {

        }
    }

}
