package algorithm.graph;

import algorithm.linear.Queue;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 14:58
 **/
public class EdgeWeightedDigraph {

    private final int V;
    private int E;
    private Queue<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        // 边e是有方向的，只需要让e出现在七点的邻接表中即可
        int v = e.from();
        adj[v].enqueue(e);
        E++;
    }

    public Queue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Queue<DirectedEdge> edges() {
        // 遍历图中的米一个顶点，得到该顶点的邻接表,遍历得到每一条边，添加到队列中即可
        Queue<DirectedEdge> allEdges = new Queue<>();

        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge : adj[v]) {
                allEdges.enqueue(edge);
            }
        }

        return allEdges;
    }
}
