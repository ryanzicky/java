package algorithm.linear;

import java.util.Iterator;

/**
 * @Author: zhourui
 * @Date: 2020-10-21 10:55
 **/
public class Queue<T> implements Iterable<T> {

    private Node head;
    private Node last;
    private int N;

    private class Node<T> {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(T t) {
        // 当前尾节点last为null
        if (last == null) {
            last = new Node(t, null);
            head.next = last;
        } else {
            // 当前尾节点last不为null
            Node oldLast = last;
            last = new Node(t, null);

            oldLast.next = last;
        }

        // 元素个数 + 1
        N++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;

        // 因为出队列其实是在删除元素,因此如果队列中的元素被删除完了，需要重置last=null
        if (isEmpty()) {
            last = null;
        }
        return (T) oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T> {
        private Node n;

        public QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return (T) n.item;
        }
    }
}
