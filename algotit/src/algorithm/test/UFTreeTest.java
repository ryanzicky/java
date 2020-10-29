package algorithm.test;

import algorithm.uf.UF_Tree;

import java.util.Scanner;

/**
 * @Author: zhourui
 * @Date: 2020-10-26 19:39
 **/
public class UFTreeTest {

    public static void main(String[] args) {
        UF_Tree uf_tree = new UF_Tree(5);
        System.out.println("默认情况下,并查集中有: " + uf_tree.count() + "个分组");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入第一个要合并的元素: ");
            int p = sc.nextInt();
            System.out.println("请输入第二个要合并的元素: ");
            int q = sc.nextInt();

            // 判断两个元素是否已经在同一组了
            if (uf_tree.connected(p, q)) {
                System.out.println(p + "元素和" + q + "元素已经在同一个组中了");
                continue;
            }

            uf_tree.union(p, q);
            System.out.println("当前并查集中还有: " + uf_tree.count() + "个分组");
        }
    }
}
