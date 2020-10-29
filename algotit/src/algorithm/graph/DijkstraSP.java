package algorithm.graph;

import algorithm.linear.Queue;
import algorithm.priority.IndexMinPriorityQueue;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 15:53
 **/
public class DijkstraSP {

    private DirectedEdge[] edgeTo;

    private double[] disTo;

    private IndexMinPriorityQueue<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        this.edgeTo = new DirectedEdge[G.V()];

        this.disTo = new double[G.V()];
        for (int i = 0; i < disTo.length; i++) {
            disTo[i] = Double.POSITIVE_INFINITY;
        }

        this.pq = new IndexMinPriorityQueue<Double>(G.V());

        // 找到图G中以顶点s为起点的最短路径树

        // 默认让顶点s进入到最想路径树中

        disTo[s] = 0.0;
        pq.insert(s, 0.0);

        // 遍历pq
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge edge : G.adj(v)) {
            // 获取到该边的重点w
            int w = edge.to();

            // 通过松弛技术，判断从起点s到顶点w的最短路径是否需要先从顶点s到顶点v，然后再由顶点v到顶点w
            if (disTo[v] + edge.weight() < disTo[w]) {
                disTo[w] = disTo[v] + edge.weight();
                edgeTo[w] = edge;

                // 判断pq中是否已经存在顶点w，如果存在，则更新权重，如果不存在，则直接添加
                if (pq.contains(w)) {
                    pq.changeItem(w, disTo[w]);
                } else {
                    pq.insert(w, disTo[w]);
                }
            }
        }
    }

    public double disTo(int v) {
        return disTo[v];
    }

    public boolean hasPathTo(int v) {
        return disTo[v] < Double.POSITIVE_INFINITY;
    }

    public Queue<DirectedEdge> pathTo(int v) {
        // 判断从顶点s到顶点w是否可达，如果不可达，直接返回null
        if (!hasPathTo(v)) {
            return null;
        }

        // 创建队列对象
        Queue<DirectedEdge> allEdges = new Queue<>();
        while (true) {
            DirectedEdge e = edgeTo[v];
            if (e == null) {
                break;
            }

            allEdges.enqueue(e);
            v = e.from();
        }

        return allEdges;
    }
}
