package algorithm.graph;

import algorithm.linear.Stack;

/**
 * @Author: zhourui
 * @Date: 2020-10-28 16:47
 **/
public class DepthFirstOrder {

    private boolean[] marked;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        // 初始化marked数组
        this.marked = new boolean[G.V()];
        // 初始化reversePost栈
        this.reversePost = new Stack<Integer>();

        // 遍历图中的每一个顶点，让每一个顶点作为入口，完成一次深度优先搜索
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    // 基于深度优先搜索,监测图G中是否有环
    private void dfs(Digraph G, int v) {
        // 标记当前v已经被搜索
        marked[v] = true;
        // 通过循环深度搜索顶点v
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        // 让顶点v进栈
        reversePost.push(v);
    }

    // 获取顶点线性序列
    public Stack<Integer> reversePost() {

        return reversePost;
    }
}