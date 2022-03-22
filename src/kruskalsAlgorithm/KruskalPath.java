package kruskalsAlgorithm;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KruskalPath {

    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public String find (String node) {

        //path compression
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));

        }
        return parent.get(node);
    }

    public void union (String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        //union - by - rank
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        }
        else {
            parent.put(root1, root2);
            if (rank.get(root1) == rank.get(root2)) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;
        int weight;
        String nodeV, nodeU;

        //1.initialize

        for(int index = 0; index < vertices.size(); index++) {
            makeSet(vertices.get(index));
        }

        //2.sorting

        Collections.sort(edges);

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        KruskalPath kObject = new KruskalPath();
        Graph graph = new Graph();
        graph.generate();

        System.out.println(kObject.kruskalFunc(graph.vertices, graph.edges));
    }


}
