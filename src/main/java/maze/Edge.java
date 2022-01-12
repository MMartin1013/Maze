package maze;
public class Edge implements Comparable<Edge>{
    private int weight;
    private Vertex source;
    private Vertex destination;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.getWeight();
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
        return source + "-" + weight + "-" + destination;
    }
}
