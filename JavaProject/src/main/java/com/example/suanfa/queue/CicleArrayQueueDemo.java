package com.example.suanfa.queue;

import java.util.Scanner;

/**
 * 环形队列
 *
 * @Author zhourui
 * @Date 2019/12/3 16:24
 */
public class CicleArrayQueueDemo {

    public static void main(String[] args){
        System.out.println("测试数组模拟唤醒队列!");

        CicleArray queue = new CicleArray(4);// 设置最大有效数据个数
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");

            key = scanner.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是:%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头数据是:%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出");
    }
}

class CicleArray {
    private int maxSize; // 表示数组的最大容量
    // front 指向队列的第一个元素，front的初始值=0
    private int front; // 队列头
    // rear 指向队列的最后一个元素的最后一个位置,rear初始值 = 0
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据,模拟队列

    public CicleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满,不能加入数据!");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将rear后移,这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据!");
        }
        // 分析front是指向队列的第一个元素
        // 1.先把front对应的值保存到一个临时变量
        // 2.将front后移
        // 3.将临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据!");
        }
        // 从front开始遍历，遍历多少个元素
        int size = size();
        for (int i = 0; i < front + size; i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据!");
        }
        return arr[front];
    }
}
