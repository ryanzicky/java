package com.example.suanfa.stack;

import java.util.Scanner;

/**
 * @Author zhourui
 * @Date 2019/12/9 15:27
 */
public class ArrayStackDemo {

    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; // 控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");

            System.out.println("请输入选择: ");
            key = scanner.next();

            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入数据");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈数据是 %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出程序");
    }
}

class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组，存放数据
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFulle() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFulle()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈,需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
