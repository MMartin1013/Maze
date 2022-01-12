package maze;
public class Edge {
    int weight;
    Vertex source;
    Vertex destination;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return source + "-" + weight + "-" + destination;
    }
}
