package dijkstraAlgorithm;

public class Edge implements Comparable<Edge> {


    public int distance;
    public String vertex;

    // 노드 생성자
    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    public String toString() {
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }

    // Comparable을 이용해 노드의 내부 순서를 설정한다.
    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }


}