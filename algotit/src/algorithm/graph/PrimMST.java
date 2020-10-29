package algorithm.graph;

import algorithm.linear.Queue;
import algorithm.priority.IndexMinPriorityQueue;

import java.net.Inet4Address;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 11:31
 **/
public class PrimMST {

    // 索引代表顶点。值表示当前顶点和最小生成树之间的最短边
    private Edge[] edgeTo;

    // 索引代表顶点。值表示当前顶点和最小生成树之前的最短边的权重
    private double[] disTo;

    // 索引代表顶点，如果当前顶点已经在树中，则值为true，否则为false
    private boolean[] marked;

    // 存放树中顶点与非树中顶点之间的有效横切位
    private IndexMinPriorityQueue<Double> pq;

    // 根据一副加权无向图，创建最小生成树计算对象
    public PrimMST(EdgeWeightedGraph G) {
        // 初始化edgeTo
        this.edgeTo = new Edge[G.V()];
        // 初始化disTo
        this.disTo = new double[G.V()];

        for (int i = 0; i < disTo.length; i++) {
            disTo[i] = Double.POSITIVE_INFINITY;
        }
        // 初始化marked
        this.marked = new boolean[G.V()];

        // 初始化pq
        pq = new IndexMinPriorityQueue<Double>(G.V());

        // 默认让顶点0进入到树中。但是树中只有一个顶点0，因此0顶点默认没有和其它顶点项链，所以disTo对应位置处的值存储0.0
        disTo[0] = 0.0;
        pq.insert(0, 0.0);

        // 遍历索引最小优先队列，拿到最小和N切对应的顶点，把该顶点加入到最小生成树中
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    // 将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph G, int v) {
        // 把顶点v添加到最小生成树中
        marked[v] = true;

        // 更新数据
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue;
            }

            // 判断边e的权重是否小于从w顶点到树中已经存在的最小边的权重
            if (e.weight() < disTo[w]) {
                // 更新数据
                edgeTo[w] = e;
                disTo[w] = e.weight();

                if (pq.contains(w)) {
                    pq.changeItem(w, e.weight());
                } else {
                    pq.insert(w, e.weight());
                }
            }
        }

    }

    // 获取最小生成树的所有边
    public Queue<Edge> edges() {
        // 创建队列对象
        Queue<Edge> allEdges = new Queue<>();

        // 遍历edgeTo数组，拿到每一条边，如果不为null，则添加到队列中
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i] != null) {
                allEdges.enqueue(edgeTo[i]);
            }
        }
        return allEdges;
    }
}


