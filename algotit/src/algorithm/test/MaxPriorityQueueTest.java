package algorithm.test;

import algorithm.priority.MaxPriorityQueue;

/**
 * @Author: zhourui
 * @Date: 2020-10-22 17:21
 **/
public class MaxPriorityQueueTest {

    public static void main(String[] args) {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<String>(10);

        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        while (!queue.isEmpty()) {
            String max = queue.delMax();
            System.out.print(max + " ");
        }
    }
}
