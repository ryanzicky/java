package com.example.suanfa.linkedlist;

import java.util.Stack;

/**
 * 演示栈stack基本使用
 *
 * @Author zhourui
 * @Date 2019/12/5 15:55
 */
public class TestStack {

    public static void main(String[] args){
        Stack<String> stack = new Stack();
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        while (stack.size() > 0) {
            System.out.println(stack.pop()); // pop取出栈顶数据
        }
    }
}
