package com.example.jvm.classloader;

/**
 * @Author: zhourui
 * @Date: 2020-09-22 11:40
 **/
public class T001_ClassLoadingProducedure {

    public static void main(String[] args) {
        System.out.println(T.count);
    }

}

class T {
    public static int count = 2;
    public static T t = new T();

    private T() {
        count++;
    }
}
