package shortestPath;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;
public class DijkstraPath {

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode, adjacentNode;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        ArrayList<Edge> nodeList;
        HashMap<String, Integer> distances = new HashMap<>();

        // 노드 배열의 거리값에 최댓값 넣기
        for(String key: graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }

        // 출발 노드 설정
        distances.put(start, 0);


        // 우선순위 큐 생성
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        // 우선순위 큐에 없데이트 된 출발 노드 값 넣기
        priorityQueue.add(new Edge(distances.get(start), start));

        while(priorityQueue.size() > 0) {

            // 우선순위 큐에서 추출
            edgeNode = priorityQueue.poll();

            // 추출 된 노드의 정보
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            // 배열에 저장 되어 있는 거리 값이 더 작을 때
            if(distances.get(currentNode) < currentDistance) {
                continue;
            }

            // 노드 A에 인접한 노드들 추출
            nodeList = graph.get(currentNode);
            for(int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;

                // 큐에서 추출된 노드의 거리와 추출된 노드와 인접한 노드의 거리의 합 = 인접한 노드까지 이동한 거리
                distance = currentDistance + weight;


                // 배열에 저장된 거리보다 인접한 노드까지 이동한 거리가 짧을 때
                if (distance < distances.get(adjacent)) {

                    // 배열 업데이트 한 뒤 우선순위 큐에 넣기
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }
        return distances;

    }

}
