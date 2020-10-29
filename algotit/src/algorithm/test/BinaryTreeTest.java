package algorithm.test;

import algorithm.tree.BinaryTree;

/**
 * @Author: zhourui
 * @Date: 2020-10-21 17:11
 **/
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        tree.put(1, "aa");
        tree.put(2, "bb");
        tree.put(3, "cc");

        System.out.println("插入完毕后的元素个数: " + tree.size());

        System.out.println("键2对应的元素: " + tree.get(2));

        tree.delete(3);
        System.out.println("删除后的元素个数: " + tree.size());
        System.out.println("删除后键3对应的元素: " + tree.get(3));

        System.out.println("最小键: " + tree.min());
        System.out.println("最大键: " + tree.max());
    }
}
