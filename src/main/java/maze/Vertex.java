package maze;
import java.util.ArrayList;

/**
 * Vertex class for containing edges and and other vertex to organize the structure of the graph class.
 * @author Manolo Martin
 */
public class Vertex implements Comparable<Vertex>{
    /**
     * Edges connected to the vertex.
     */
    private ArrayList<Edge> edges;

    /**
     * Vertices that are perpendicular or parallel to this vertex in the graphs
     * adjacency matrix.
     */
    private ArrayList<Vertex> neighbors;

    /**
     * This vertex's unique id.
     */
    private int id;

    /**
     * Creates a new vertex with a unique id.
     * @param id the id is the count of vertices.
     */
    public Vertex(int id) {
        this.id = id;
        edges = new ArrayList<>();
        neighbors = new ArrayList<>();
    }

    /**
     * Gets the vertex's id.
     * @return Vertex's unique id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the edges connected to this vertex.
     * @return an ArrayList of edges.
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    
    /**
     * Gets the adjacent and perpendicular vertices.
     * @return an ArrayList of neighbors.
     */
    public ArrayList<Vertex> getNeighbors() {
        return neighbors;
    }
    
    /**
     * Adds a neighbor to the list of the vertex's neighbors.
     * @param vertex to be added to the list of neighbors.
     * @return false if the neighbor list already contains this vertex or 
     * if the destination is null and true if the operation was successful.
     */
    public boolean addNeighbor(Vertex vertex) {
        if(vertex == null) return false;
        return neighbors.add(vertex);
    }

    /**
     * Adds an edge to the list of this vertex's edges and adds the destination to 
     * the neighbors list if it is not already present.
     * @param destination that this edge will lead to.
     * @return false if the edge list already contains this destination or 
     * if the destination is null and true if the operation was successful.
     */
    public boolean addEdge(Vertex destination) {
        if(destination == null || edges.contains(new Edge(this,destination))) return false;
        if(!neighbors.contains(destination)) neighbors.add(destination);
        return edges.add(new Edge(this, destination));
    }

    /**
     * Adds an edge to the list of this vertex's edges and adds the destination to 
     * the neighbors list if it is not already present.
     * @param edge to be added to the list of edges.
     * @return false if the edge list already contains this destination or 
     * if the destination is null and true if the operation was successful.
     */
    public boolean addEdge(Edge edge) {
        if(edge == null || edges.contains(edge)) return false;
        if(!neighbors.contains(edge.getDestination())) neighbors.add(edge.getDestination());
        return edges.add(edge);
    }

    /**
     * Removes an edge from the list of edges.
     * @param edge to be removed from the list.
     * @return true if the edge was removed and false if otherwise.
     */
    public boolean removeEdge(Edge edge) {
        return edges.remove(edge);
    }

    @Override
    public int compareTo(Vertex o) {
        return  this.id - o.id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof Vertex)) {
            return false;
        }

        Vertex o = (Vertex)obj;

        return o.id == this.id;
    }

    /**
     * Returns the string representation of the vertex.
     * @return Vertex's unique id as a string.
     */
    @Override
    public String toString() {
        return id + "";
    }
}