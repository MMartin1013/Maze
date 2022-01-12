import java.util.ArrayList;
import java.util.Random;

public class Vertex implements Comparable<Vertex>{
    private Random rand = new Random();
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

    public void addEdge(Vertex destination) {
        if(destination == null) return;
        edges.add(new Edge(this, destination, rand.nextInt(51)));
    }

    @Override
    public int compareTo(Vertex o) {
        return  o.id - this.id;
    }

    @Override
    public String toString() {
        return id + "";
    }
}