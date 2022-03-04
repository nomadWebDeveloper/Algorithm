package bfsSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BfsSearch {



    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String StartNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(StartNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(0);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        BfsSearch bfsSearch = new BfsSearch();
        System.out.println(bfsSearch.bfsFunc(graph, "A"));

    }

}