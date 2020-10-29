package algorithm.test;

import algorithm.tree.BinaryTree;

/**
 * @Author: zhourui
 * @Date: 2020-10-21 17:11
 **/
public class BinaryTreeMaxDepthTest {

    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        int maxDepth = tree.maxDepth();
        System.out.println("maxDepth = " + maxDepth);
    }
}
