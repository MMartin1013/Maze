package maze;
import java.util.PriorityQueue;

public class Graph {

    /**
     * Used to generate unique ids for the vertexes
     */
    public int vertexCount = 0;

    private final int DEFAULT_BOUNDS = 5;
    
    private int size;

    /**
     * Holds all vertexes
     */
    private Vertex[][] adjMatrix;
    
    /**
     * Default Constructor.
     */
    public Graph() {
        size = DEFAULT_BOUNDS;
        adjMatrix = new Vertex[DEFAULT_BOUNDS][DEFAULT_BOUNDS];
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = new Vertex(vertexCount++);
            }
        }
        
        generateEdges();
    }

    public Graph(int bounds) {
        size = bounds;
        adjMatrix = new Vertex[bounds][bounds]; 

        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = new Vertex(vertexCount++);
            }
        }

        generateEdges();
    }

    public void generateEdges() {
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                Vertex source = adjMatrix[i][j];
                // Vertex W = (j == 0) ? null : adjMatrix[i][j - 1];
                Vertex E = (j == adjMatrix[i].length - 1) ? null : adjMatrix[i][j + 1];
                // Vertex N = (i == 0) ? null : adjMatrix[i - 1][j];
                Vertex S = (i  == adjMatrix.length - 1) ? null : adjMatrix[i + 1][j];
                // source.addEdge(N);
                source.addEdge(S);                
                // source.addEdge(W);
                source.addEdge(E);
            }
        }
    }   

    public Vertex[][] getAdjMatrix() {
        return adjMatrix;
    }

    public PriorityQueue<Edge> getEdges() {
        PriorityQueue<Edge> edges = new PriorityQueue<>();

        for(int i = 0; i < adjMatrix.length; i++){
            for(int j = 0; j < adjMatrix[i].length; j++){
                for(Edge edge : adjMatrix[i][j].getEdges()){
                    edges.add(edge);
                }  
            }
        }

        return edges;
    }

    public int getSize() {
        return size * size;
    }

    public void showEdges(){
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix[i].length; j++) { 
                System.out.print("|_");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix[i].length; j++) {
                str.append(adjMatrix[i][j] + " ");
            }
            str.append("\n");
        }

        return str.toString();
    }
}
