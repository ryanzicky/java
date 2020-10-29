package algorithm.test;

import algorithm.linear.Queue;
import algorithm.tree.BinaryTree;

/**
 * @Author: zhourui
 * @Date: 2020-10-22 09:46
 **/
public class BinaryTreeErgodicTest {

    // 前序遍历
    /*public static void main(String[] args) {
        BinaryTree<String, String> algorithm.tree = new BinaryTree<>();

        algorithm.tree.put("E", "5");
        algorithm.tree.put("B", "2");
        algorithm.tree.put("G", "7");
        algorithm.tree.put("A", "1");
        algorithm.tree.put("D", "4");
        algorithm.tree.put("F", "6");
        algorithm.tree.put("H", "8");
        algorithm.tree.put("C", "3");

        Queue<String> keys = algorithm.tree.preErgodic();

        for (String key : keys) {
            String value = algorithm.tree.get(key);
            System.out.println(key + "-------" + value);
        }

    }*/


    // 中序遍历
    /*public static void main(String[] args) {
        BinaryTree<String, String> algorithm.tree = new BinaryTree<>();

        algorithm.tree.put("E", "5");
        algorithm.tree.put("B", "2");
        algorithm.tree.put("G", "7");
        algorithm.tree.put("A", "1");
        algorithm.tree.put("D", "4");
        algorithm.tree.put("F", "6");
        algorithm.tree.put("H", "8");
        algorithm.tree.put("C", "3");

        Queue<String> keys = algorithm.tree.midErgodic();

        for (String key : keys) {
            String value = algorithm.tree.get(key);
            System.out.println(key + "-------" + value);
        }

    }*/

    // 后序遍历
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

        Queue<String> keys = tree.afterErgodic();

        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key + "-------" + value);
        }
    }
}
