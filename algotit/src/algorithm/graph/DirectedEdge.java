package algorithm.graph;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 14:55
 **/
public class DirectedEdge {

    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }
}
