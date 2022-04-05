package primsAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {

    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        ArrayList<Edge> adjacentEdgeNodes = new ArrayList<>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();

        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList = new ArrayList<>();
        ArrayList<Edge> candidateEdgeList = new ArrayList<>();
        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<>());

        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while(priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if(!connectedNodes.contains(poppedEdge.node2)) {
                // 해당 edge 를 mst에 추가

                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
                for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;

    }

    public static void main(String[] args) {
        PrimPath pObject = new PrimPath();
        Graph graph = new Graph();
        graph.generate();
        System.out.println(pObject.primFunc("A", graph.myedges));

    }
}
