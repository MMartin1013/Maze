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

    @Override
    public int compareTo(Vertex o) {
        return  o.id - this.id;
    }
}