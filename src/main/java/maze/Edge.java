package maze;

/**
 * Edge class to contain connections between vertices and organize the graph structure.
 * @author Manolo Martin
 */
public class Edge {
    /**
     * Starting vertex in the edge.
     */
    private Vertex source;

    /**
     * Ending vertex in the edge.
     */
    private Vertex destination;

    /**
     * Creates a new edge with a starting and ending vertex.
     * @param source is the starting vertex.
     * @param destination is the ending vertex.
     */
    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }

    /**
     * Gets the starting vertex in the edge.
     * @return the source.
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * Gets the ending vertex in the edge.
     * @return the destination.
     */
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
