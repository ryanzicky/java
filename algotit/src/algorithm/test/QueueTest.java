package algorithm.test;

import algorithm.linear.Queue;

/**
 * @Author: zhourui
 * @Date: 2020-10-21 11:10
 **/
public class QueueTest {

    public static void main(String[] args) {
        // 创建队列对象
        Queue<String> q = new Queue<>();
        // 测试队列enqueue方法
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");

        q.forEach(s -> System.out.println(s));

        System.out.println("=======================================");
        // 测试队列dequeue方法
        String result = q.dequeue();
        System.out.println("出队列的元素是: " + result);
        System.out.println("剩余的元素个数是: " + q.size());
    }
}
