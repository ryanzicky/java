package algorithm.graph;

import algorithm.linear.Queue;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 10:47
 **/
public class EdgeWeightedGraph {

    // 顶点总数
    private final int V;
    // 边的总数
    private int E;
    // 邻接表
    private Queue<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        // 需要让边e同时出现在e这个边的两个顶点的邻接表中
        int v = e.either();
        int w = e.other(v);

        adj[v].enqueue(e);
        adj[w].enqueue(e);

        E++;
    }

    public Queue<Edge> adj(int v) {
        return adj[v];
    }

    public Queue<Edge> edges() {
        // 创建一个队列对象，存储所有的边
        Queue<Edge> allEdges = new Queue<>();

        // 遍历图中的每一个顶点，找到该顶点的邻接表,邻接表中存储了该顶点关联的每一条边

        // 因为是无向图，所有同一条边同时出现在了它关联的两个顶点的邻接表中,需要让一条边只记录一次
        for (int v = 0; v < V; v++) {
            // 遍历v顶点的邻接表，找到每一条和v关联的边
            for (Edge e : adj(v)) {
                if (e.other(v) < v) {
                    allEdges.enqueue(e);
                }
            }
        }

        return allEdges;
    }
}