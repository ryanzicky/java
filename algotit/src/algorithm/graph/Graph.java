package algorithm.graph;

import algorithm.linear.Queue;

/**
 * 图
 *
 * @Author: zhourui
 * @Date: 2020-10-27 15:14
 **/
public class Graph {

    // 顶点数目
    private final int V;
    // 边的数目
    private int E;
    // 邻接表
    private Queue<Integer>[] adj;

    public Graph(int v) {
        // 初始化顶点数目
        this.V = v;
        // 初始化边的数目
        this.E = 0;
        // 初始化邻接表
        this.adj = new Queue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    // 获取顶点数目
    public int V() {
        return V;
    }

    // 获取边的数目
    public int E() {
        return E;
    }

    // 向途中添加一条边 v-w
    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        adj[w].enqueue(v);

        E++;
    }

    public Queue<Integer> adj(int v) {
        return adj[v];
    }
}
