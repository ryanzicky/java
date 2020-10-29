package algorithm.test;

import algorithm.heap.Heap;

/**
 * @Author: zhourui
 * @Date: 2020-10-22 14:59
 **/
public class HeapTest {

    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(10);

        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        heap.insert("H");
        heap.insert("I");

        String result = null;
        while ((result = heap.delMax()) != null) {
            System.out.print(result + " ");
        }



    }
}
