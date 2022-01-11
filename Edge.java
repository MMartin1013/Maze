public class Edge {
    int weight;
    Vertex source;
    Vertex destination;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
