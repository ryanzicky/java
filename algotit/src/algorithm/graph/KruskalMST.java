package algorithm.graph;

import algorithm.linear.Queue;
import algorithm.priority.MinPriorityQueue;
import algorithm.uf.UF_Tree_Weighted;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 13:57
 **/
public class KruskalMST {

    private Queue<Edge> mst;
    private UF_Tree_Weighted uf;
    private MinPriorityQueue<Edge> pq;

    public KruskalMST(EdgeWeightedGraph G) {
        this.mst = new Queue<Edge>();

        this.uf = new UF_Tree_Weighted(G.V());

        this.pq = new MinPriorityQueue<Edge>(G.E() + 1);

        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            // 找到权重最小的边
            Edge e = pq.delMin();
            // 找到该边的两个顶点
            int v = e.either();
            int w = e.other(v);

            // 判断两个顶点是否已经在同一棵树中
            if (uf.connected(v, w)) {
                continue;
            }

            uf.union(v, w);

            mst.enqueue(e);
        }
    }

    public Queue<Edge> edges() {
        return mst;
    }
}
