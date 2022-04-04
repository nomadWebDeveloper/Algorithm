package primsAlgorithm;

import java.util.PriorityQueue;

public class Graph {
    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

    public void generate() {
        priorityQueue.add(new Edge(2, "A", "B"));
    }
}
