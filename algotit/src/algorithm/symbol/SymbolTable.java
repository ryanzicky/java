package algorithm.symbol;

/**
 * 符号表
 *
 * @Author: zhourui
 * @Date: 2020-10-21 11:26
 **/
public class SymbolTable<Key, Value> {

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

    public SymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        // 1. 符号表中已经存在了键为key的键值对，那么只需要找到该节点，替换值为value即可
        Node n = head;
        while (n.next != null) {
            // 变换n
            n = n.next;
            // 判断n节点存储的键是否为key，如果是，替换n节点的值
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        // 2. 如果符号表中不存在键为key的键值对，只需要创建新的节点，保存要插入的键值对，新街点插入到链表的头部，head.next = 新节点
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next = oldFirst;
        head.next = newNode;
        // 3. 元素个数+1
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
