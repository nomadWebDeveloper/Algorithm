package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DijkstraPathTest {
    public static void main(String[] args) {

        // 그래프 생성
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge(5, "A"))));


        DijkstraPath dObject = new DijkstraPath();

        // 출발 노드가 A인 다익스트라 알고리즘
        System.out.println(dObject.dijkstraFunc(graph, "A"));
    }
}
