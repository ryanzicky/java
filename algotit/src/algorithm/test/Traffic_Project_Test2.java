package algorithm.test;

import algorithm.graph.DepthFirstSearch;
import algorithm.graph.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: zhourui
 * @Date: 2020-10-27 11:13
 **/
public class Traffic_Project_Test2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test2.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        int totalNum = Integer.parseInt(br.readLine());

        Graph G = new Graph(totalNum);
        int roadNum = Integer.parseInt(br.readLine());

        for (int i = 1; i <= roadNum; i++) {
            String road = br.readLine();
            String[] str = road.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);

            G.addEdge(v, w);
        }

        DepthFirstSearch search = new DepthFirstSearch(G, 9);

        System.out.println("顶点8和顶点9是否相通: " + search.marked(8));
        System.out.println("顶点10和顶点9是否相通: " + search.marked(10));
    }

}
