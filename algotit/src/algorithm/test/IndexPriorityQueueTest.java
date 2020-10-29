package algorithm.test;

import algorithm.priority.IndexMinPriorityQueue;

/**
 * @Author: zhourui
 * @Date: 2020-10-23 14:34
 **/
public class IndexPriorityQueueTest {

    public static void main(String[] args) {
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);

        queue.insert(0, "A");
        queue.insert(1, "C");
        queue.insert(2, "F");

        queue.changeItem(2, "B");

        while (!queue.isEmpty()) {
            int minIndex = queue.delMin();
            System.out.print(minIndex + " ");
        }
    }
}
