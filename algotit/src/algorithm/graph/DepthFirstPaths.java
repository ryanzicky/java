package algorithm.graph;

import algorithm.linear.Stack;

/**
 * @Author: zhourui
 * @Date: 2020-10-27 17:08
 **/
public class DepthFirstPaths {

    private boolean[] marked;
    // 起点
    private int s;
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.s = s;
        this.edgeTo = new int[G.V()];

        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        // 把v表示已搜索
        marked[v] = true;

        // 遍历顶点v的邻接表，拿到每一个相邻的顶点，继续递归搜索
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v; // 到达顶点w的路径上的最后一个顶点是v
                dfs(G, w);
            }
        }
    }

    private boolean hashPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hashPathTo(v)) {
            return null;
        }

        // 创建栈对象，保存路径中的所有顶点
        Stack<Integer> path = new Stack<>();
        // 通过循环，从顶点v开始，一直往前找，到找到起点为止
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        // 把起点s放到栈中
        path.push(s);

        return path;

    }
}
