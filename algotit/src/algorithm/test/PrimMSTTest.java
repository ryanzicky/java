package algorithm.test;

import algorithm.graph.Edge;
import algorithm.graph.EdgeWeightedGraph;
import algorithm.graph.PrimMST;
import algorithm.linear.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: zhourui
 * @Date: 2020-10-29 13:43
 **/
public class PrimMSTTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(PrimMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));

        int total = Integer.parseInt(br.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(total);

        int edgeNums = Integer.parseInt(br.readLine());

        for (int i = 1; i <= edgeNums; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            double weight = Double.parseDouble(str[2]);

            // 构建加权无向边
            Edge edge = new Edge(v, w, weight);
            G.addEdge(edge);
        }

        PrimMST primMST = new PrimMST(G);
        Queue<Edge> edges = primMST.edges();

        for (Edge e : edges) {
            int v = e.either();
            int w = e.other(v);
            double weight = e.weight();

            System.out.println(v + "-" + w + " : " + weight);
        }
    }
}
