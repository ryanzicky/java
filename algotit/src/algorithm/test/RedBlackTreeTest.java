package algorithm.test;

import algorithm.tree.RedBlackTree;

/**
 * @Author: zhourui
 * @Date: 2020-10-23 17:15
 **/
public class RedBlackTreeTest {

    public static void main(String[] args) {
        RedBlackTree<String, String> tree = new RedBlackTree<>();

        tree.put("1", "aaaa");
        tree.put("2", "bbbb");
        tree.put("3", "cccc");

        String r1 = tree.get("1");
        System.out.println(r1);

        String r2 = tree.get("2");
        System.out.println(r2);

        String r3 = tree.get("3");
        System.out.println(r3);
    }
}
