package algorithm.test;

import algorithm.uf.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: zhourui
 * @Date: 2020-10-27 11:13
 **/
public class Traffic_Project_Test {

    public static void main(String[] args) throws IOException {
        // 构建一个缓冲读取流BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        // 读取第一行数据20
        int totalNum = Integer.parseInt(br.readLine());
        // 构建一个并查集对象
        UF_Tree_Weighted uf_tree_weighteed = new UF_Tree_Weighted(totalNum);
        // 读取第二行数据7
        int roadNum = Integer.parseInt(br.readLine());
        // 循环读取7条道路
        for (int i = 1; i <= roadNum; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);

            // 调用并查集对象的union方法让两个城市相通
            uf_tree_weighteed.union(p, q);
        }
        // 获取当前并查集中分组的数量-1就可以得到还需要修建的道路条数
        int roads = uf_tree_weighteed.count() - 1;
        System.out.println("还需要修建" + roads + "条道路.");

    }

}
