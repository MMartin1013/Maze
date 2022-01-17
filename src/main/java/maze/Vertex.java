package maze;
import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
    private ArrayList<Edge> edges;
    private ArrayList<Vertex> neighbors;
    private int id;

    public Vertex(int id) {
        this.id = id;
        edges = new ArrayList<>();
        neighbors = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
    
    public ArrayList<Vertex> getNeighbors() {
        return neighbors;
    }
    
    public boolean addNeighbor(Vertex vertex) {
        if(vertex == null) return false;
        neighbors.add(vertex);
        return true;
    }

    public boolean addEdge(Vertex destination) {
        if(destination == null || edges.contains(new Edge(this,destination))) return false;
        edges.add(new Edge(this, destination));
        if(!neighbors.contains(destination)) neighbors.add(destination);
        return true;
    }

    public boolean addEdge(Edge edge) {
        if(edge == null || edges.contains(edge)) return false;
        edges.add(edge);
        if(!neighbors.contains(edge.getDestination())) neighbors.add(edge.getDestination());
        return true;
    }

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

    @Override
    public String toString() {
        return id + "";
    }
}