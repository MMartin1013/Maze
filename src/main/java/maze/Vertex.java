package maze;
import java.util.ArrayList;
import java.util.Random;

public class Vertex implements Comparable<Vertex>{
    private Random rand = new Random();
    private ArrayList<Edge> edges;
    private int id;

    public Vertex(int id) {
        this.id = id;
        edges = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public boolean addEdge(Vertex destination) {
        if(destination == null) return false;
        edges.add(new Edge(this, destination, rand.nextInt(51)));
        return true;
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