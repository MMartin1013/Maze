package maze;
public class Edge {
    private Vertex source;
    private Vertex destination;

    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof Edge)) {
            return false;
        }

        Edge o = (Edge)obj;

        return o.source == this.source && this.destination == o.destination;
    }

    @Override
    public String toString() {
        return source + "--" + destination;
    }
}
