package algorithm.test;

import algorithm.linear.Queue;

/**
 * 折纸问题
 *
 * @Author: zhourui
 * @Date: 2020-10-22 11:20
 **/
public class PagerFoldingTest {

    public static void main(String[] args) {
        Node<String> tree = createTree(3);
        printTree(tree);
    }

    // 通过模拟对折N次纸产生树
    public static Node<String> createTree(int N) {
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            // 当前是第一次对折
            if (i == 0) {
                root = new Node<String>("down", null, null);
                continue;
            }
            // 当前不是第一次对折
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);

            // 循环遍历队列
            while (!queue.isEmpty()) {
                // 从队列中弹出一个节点
                Node<String> tmp = queue.dequeue();
                // 如果有左子节点，则把左子节点放入到队列中
                if (tmp.left != null) {
                    queue.enqueue(tmp.left);
                }
                // 如果有右子节点，则把右子节点放入到队列中
                if (tmp.right != null) {
                    queue.enqueue(tmp.right);
                }
                // 如果同时没有左子节点和右子节点，那么证明该节点是叶子节点，只需要给该节点添加左子节点和右子节点即可
                if (tmp.left == null && tmp.right == null) {
                    tmp.left = new Node<String>("down", null, null);
                    tmp.right = new Node<String>("up", null, null);
                }
            }
        }
        return root;
    }

    // 打印树中每个节点到控制台
    public static void printTree(Node<String> root) {
        // 需要中序遍历完成
        if (root == null) {
            return;
        }
        // 打印左子树的节点
        if (root.left != null) {
            printTree(root.left);
        }
        System.out.print(root.item + " ");
        // 打印右子树的节点
        if (root.right != null) {
            printTree(root.right);
        }
    }

    private static class Node<T> {
        public T item;
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
