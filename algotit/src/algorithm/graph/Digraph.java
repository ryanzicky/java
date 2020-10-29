package algorithm.graph;

import algorithm.linear.Queue;

/**
 * @Author: zhourui
 * @Date: 2020-10-28 11:52
 **/
public class Digraph {

    // 顶点数目
    private final int V;
    // 边的数目
    private int E;
    // 邻接表
    private Queue<Integer>[] adj;

    public Digraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        // 只需要让顶点w出现再顶点v的邻接表中，因为边是有方向的，最终，顶点v的邻接表中存储的相邻顶点的含义是: v -> 其他顶点
        adj[v].enqueue(w);
        E++;
    }

    // 获取由v指出的边所连接的所有顶点
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph r = new Digraph(V);

        for (int v = 0; v < V; v++) {
            // 获取由该顶点v指出的所有变
            for (Integer w : adj[v]) { // 原图中表示的是有顶点v -> w的边
                r.addEdge(w, v); // w -> v
            }
        }

        return r;
    }
}
