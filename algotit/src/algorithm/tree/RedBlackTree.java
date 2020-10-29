package algorithm.tree;

/**
 * 红黑树
 *
 * @Author: zhourui
 * @Date: 2020-10-23 16:51
 **/
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    // 获取树中元素个数
    public int size() {
        return N;
    }

    // 当前节点的父指向链接是否为红色
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    // 左旋
    private Node rotateLeft(Node h) {
        // 获取x节点的右子节点，标识为x
        Node x = h.right;
        // 让x节点的左子节点成为h节点的右子节点
        h.right = x.left;
        // 让h成为x节点的左子节点
        x.left = h;
        // 让x节点color属性等于h的color属性
        x.color = h.color;
        // 让h节点的color属性变为红色
        h.color = RED;
        return x;
    }

    // 右旋
    private Node rotateRight(Node h) {
        // 获取x节点的左子节点，标识为x
        Node x = h.left;
        // 让x节点的右子节点成为h节点的左子节点
        h.left = x.right;
        // 让h成为x节点的右子节点
        x.right = h;
        // 让x节点color属性等于h的color属性
        x.color = h.color;
        // 让h节点的color属性变为红色
        h.color = RED;
        return x;
    }

    // 颜色反转，相当于完成拆分4-节点
    private void flipColors(Node h) {
        // 当前节点变为红色
        h.color = RED;
        // 左子节点和右子节点变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // 在整个树上完成插入操作
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = RED;
    }

    private Node put(Node h, Key key, Value value) {
        // 判断h是否为空，如果为空则直接返回一个红色的节点
        if (h == null) {
            N++;
            return new Node(key, value, null, null, RED);
        }
        // 比较h节点的键和key的大小
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            // 继续往左
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            // 继续往右
            h.right = put(h.right, key, value);
        } else {
            // 发生值的交换
            h.value = value;
        }

        // 左旋 当当前节点h的左子节点和右子节点为黑色，右子节点为红色，需要左旋
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        // 右旋 当当前节点h的左子节点和左子节点的左子节点都为红色，需要右旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h= rotateRight(h);
        }
        // 颜色反转 当前节点的左子节点和右子节点都为红色时，需要反转
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

}
