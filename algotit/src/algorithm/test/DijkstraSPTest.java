package algorithm.test;

import algorithm.graph.DijkstraSP;
import algorithm.graph.DirectedEdge;
import algorithm.graph.EdgeWeightedDigraph;
import algorithm.linear.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 16:11
 **/
public class DijkstraSPTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(DijkstraSPTest.class.getClassLoader().getResourceAsStream("min_route_test.txt")));

        int total = Integer.parseInt(br.readLine());
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(total);

        int edgeNums = Integer.parseInt(br.readLine());
        for (int i = 1; i <= edgeNums; i++) {
            String line = br.readLine();
            String[] strs = line.split(" ");

            int v = Integer.parseInt(strs[0]);
            int w = Integer.parseInt(strs[1]);
            double weight = Double.parseDouble(strs[2]);

            DirectedEdge e = new DirectedEdge(v, w, weight);
            G.addEdge(e);
        }
        DijkstraSP dijkstraSP = new DijkstraSP(G, 0);

        Queue<DirectedEdge> edges = dijkstraSP.pathTo(6);

        for (DirectedEdge edge : edges) {
            System.out.println(edge.from() + "->" + edge.to() + " : " + edge.weight());
        }
    }
}
