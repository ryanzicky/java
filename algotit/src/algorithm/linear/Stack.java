package algorithm.linear;

import java.util.Iterator;

/**
 * @Author: zhourui
 * @Date: 2020-10-20 17:39
 **/
public class Stack<T> implements Iterable<T> {

    private Node<T> head;
    private int N;

    // 结点类
    public class Node<T> {
        // 存储数据
        public T item;
        // 下一个结点
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null, null);

    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return N;
    }

    // 吧t元素压入栈
    public void push(T t) {
        // 找到首节点指向的第一个节点
        Node oldFirst = head.next;
        // 创建新节点
        Node newNode = new Node(t, null);
        // 让首节点指向新节点
        head.next = newNode;
        // 让新节点指向原来的第一个节点
        newNode.next = oldFirst;
        // 元素个数+1
        N++;
    }

    public T pop() {
        // 找到首节点指向的第一个节点
        Node oldFirst = head.next;
        if (oldFirst == null) {
            return null;
        }
        // 让首节点指向原来第一个节点的下一个节点
        head.next = oldFirst.next;
        // 元素个数-1
        N--;
        return (T) oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return null != n.next;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
