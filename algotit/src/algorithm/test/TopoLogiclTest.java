package algorithm.test;

import algorithm.graph.Digraph;
import algorithm.graph.TopoLogical;
import algorithm.linear.Stack;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 09:55
 **/
public class TopoLogiclTest {

    public static void main(String[] args) {
        // 准备有向图
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 3);
        digraph.addEdge(2, 4);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 5);
        digraph.addEdge(1, 3);

        // 听过TopoLigic对象对有向图中的顶点进行排序
        TopoLogical topoLogical = new TopoLogical(digraph);

        // 获取顶点的线性队列进行打印
        Stack<Integer> order = topoLogical.order();
        StringBuilder sb = new StringBuilder();
        for (Integer w : order) {
            sb.append(w).append("->");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
