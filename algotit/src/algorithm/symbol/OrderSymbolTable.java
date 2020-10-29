package algorithm.symbol;

/**
 * 有序符号表
 *
 * @Author: zhourui
 * @Date: 2020-10-21 11:26
 **/
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {

    private Node head;
    private int N;

    private class Node {
        public Key key;
        public Value value;

        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        // 定义两个node变量，分别记录当前节点和当前节点的上一个节点

        Node curr = head.next;
        Node pre = head;

        while (curr != null && key.compareTo(curr.key) > 0) {
            // 变换当前节点和前一个节点即可
            pre = curr;
            curr = curr.next;
        }

        // 如果当前节点curr的key和要插入的key一样，则替换
        if (curr != null && key.compareTo(curr.key) == 0) {
            curr.value = value;
            return;
        }

        // 如果当前节点curr的键和要插入的可以不一样，把新的节点插入到curr之前
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;

        N++;
    }

    public void delete(Key key) {
        Node n = head;
        while (n.next != null) {
            // 判断n节点的下一个节点分键是否为key，如果是，就删除该节点
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
            }

            // 变换n
            n = n.next;
        }
    }

    public Value get(Key key) {
        Node n = head;
        while (n.next != null) {
            // 变换n
            n = n.next;
            if (n.next.key.equals(key)) {
                return n.next.value;
            }
        }
        return null;
    }
}
