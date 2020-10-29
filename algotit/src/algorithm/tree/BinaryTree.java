package algorithm.tree;

import algorithm.linear.Queue;

/**
 * 2-3 树
 *
 * @Author: zhourui
 * @Date: 2020-10-21 16:00
 **/
public class BinaryTree<Key extends Comparable<Key>, Value> {

    private Node root;
    private int N;

    private class Node {
        private Key key;

        private Value value;

        private Node left;

        private Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        // 如果x子树为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        // 如果x子树不为空
        // 比较x节点的键和key的大小:
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // 如果key小于x节点的键，则继续找x节点的左子树
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            // 如果key大于x节点的键，则继续找x节点的右子树
            x.right = put(x.right, key, value);
        } else {
            // 如果key等于x节点的键，则替换x节点的值为value
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            // x树为null
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // 如果key小于x节点的键，则继续找x节点的左子树
            return get(x.left, key);
        } else if (cmp > 0) {
            // 如果key大于x节点的键，则继续找x节点的右子树
            return get(x.right, key);
        } else {
            // 如果key等于x节点的键，就找到了键为key的节点，返回x节点的值
            return x.value;
        }
    }

    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // 如果key小于x节点的键，则继续找x节点的左子树
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            // 如果key大于x节点的键，则继续找x节点的右子树
            x.right = delete(x.right, key);
        } else {
            // 让元素个数-1
            N--;


            // 如果key等于x节点的键，完成真正的删除节点动作，要删除的节点就是x

            // 找到右子树中最小节点，替换成当前节点
            if (x.right == null) {
                return x.left;
            }

            if (x.left == null) {
                return x.right;
            }

            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            // 删除右子树中最小的节点
            Node n = x.right;
            while (n.left != null) {
                if (n.left == null) {
                    n.left = null;
                } else {
                    // 变换n节点
                    n = n.left;
                }
            }

            // 让x节点的左子树成为minNode的左子树
            minNode.left = x.left;
            // 让x节点的右子树成为minNode的右子树
            minNode.right = x.right;
            // 让x节点的父节点指向minNode
            x = minNode;

        }

        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }

    // 前序遍历
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    public void preErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        //  把x节点的key放入到keys中
        keys.enqueue(x.key);
        // 递归遍历x节点的左子树
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        // 递归遍历新节点的右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    // 使用中序遍历获取树中所有的键
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        // 先递归把左子树的键放到keys中
        if (x.left != null) {
            midErgodic(x.left, keys);
        }

        // 把当前节点x的键放到keys中
        keys.enqueue(x.key);

        // 再递归吧右子树的键放到keys中
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    // 后序遍历
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    private void afterErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        // 先递归把左子树的键放到keys中
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }

        // 再递归吧右子树的键放到keys中
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }

        // 把当前节点x的键放到keys中
        keys.enqueue(x.key);
    }

    // 获取整个树的最大深度
    public int maxDepth() {
        return maxDepth(root);
    }

    // 获取指定树的最大深度
    private int maxDepth(Node x) {
        if (x == null) {
            return 0;
        }
        int maxL = 0;
        int maxR = 0;
        // 计算x节点左子树的最大深度
        if (x.left != null) {
            maxL = maxDepth(x.left);
        }
        // 计算x节点右子树的最大深度
        if (x.right != null) {
            maxR = maxDepth(x.right);
        }

        // 比较左子树和右子树最大深度，取较大值 + 1

        return maxL > maxR ? maxL + 1 : maxR + 1;
    }
}
