package algorithm.graph;

/**
 * 深度优先搜索
 *
 * @Author: zhourui
 * @Date: 2020-10-27 15:45
 **/
public class DepthFirstSearch {

    private boolean[] marked;

    private int count;

    // 构造深度优先搜索对象，使用深度优先
    public DepthFirstSearch(Graph G, int s) {
        // 初始化marked数组
        this.marked = new boolean[G.V()];
        // 初始化跟顶点s相通的顶点的数量
        this.count = 0;

        dfs(G, s);
    }

    // 使用深度优先搜索找出G图中v顶点的所有相邻顶点
    private void dfs(Graph G, int v) {
        // 把v顶点标识为已搜索
        marked[v] = true;

        for (Integer w : G.adj(v)) {
            // 判断当前w顶点有没有被搜索过
            if (!marked[w]) {
                dfs(G, w);
            }
        }

        // 相通顶点数量+ 1
        this.count++;
    }

    // 判断w顶点与s顶点是否相通
    public boolean marked(int w) {
        return marked[w];
    }

    // 获取与顶点s相通的所有顶点的总数
    public int count() {
        return count;
    }
}
