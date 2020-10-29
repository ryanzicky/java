package algorithm.graph;

import algorithm.linear.Stack;

/**
 * 图_拓扑排序
 *
 * @Author: zhourui
 * @Date: 2020-10-29 09:41
 **/
public class TopoLogical {

    private Stack<Integer> order;

    public TopoLogical(Digraph G) {
        DirectedCycle cycle = new DirectedCycle(G);
        if (!cycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    // 判断图G是否有环
    private boolean isCycle() {
        return order == null;
    }

    public Stack<Integer> order() {
        return order;
    }

}
