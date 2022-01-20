package maze;
import java.util.ArrayList;

/**
 * Implementation of the graph data structure geared mostly towards 
 * maze building.
 * @author Manolo Martin
 */
public class Graph {

    /**
     * Used to generate unique ids for the vertexes
     */
    private int vertexCount = 0;

    /**
     * Default bounds that will be used if they are not specified.
     */
    private static final int DEFAULT_BOUNDS = 5;
    
    /**
     * Dimensions of the graph
     */
    private int bounds;

    /**
     * Adjacency matrix that holds all of the vertices.
     */
    private Vertex[][] adjMatrix;
    
    /**
     * Makes a new graph with the default bounds. Fills each index
     * of the adjacency matrix with a new vertex with an id of the 
     * current vertex count. Also populates the neighbors list of 
     * each vertex.
     */
    public Graph() {
        bounds = DEFAULT_BOUNDS;
        adjMatrix = new Vertex[DEFAULT_BOUNDS][DEFAULT_BOUNDS];
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = new Vertex(vertexCount++);
            }
        }

        generateNeighbors();
    }

    /**
     * Makes a new graph with the specified bounds and follows the same 
     * steps of the default constructor.
     * @param bounds of the graph.
     */
    public Graph(int bounds) {
        this.bounds = bounds;
        adjMatrix = new Vertex[bounds][bounds]; 

        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = new Vertex(vertexCount++);
            }
        }

        generateNeighbors();
    }

    /**
     * Populates the neighbors list of each vertex with the vertices that are
     * parallel and perpendicular to them.
     */
    public void generateNeighbors() {
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                Vertex source = adjMatrix[i][j];
                Vertex west = (j == 0) ? null : adjMatrix[i][j - 1];
                Vertex east = (j == adjMatrix[i].length - 1) ? null : adjMatrix[i][j + 1];
                Vertex north = (i == 0) ? null : adjMatrix[i - 1][j];
                Vertex south = (i  == adjMatrix.length - 1) ? null : adjMatrix[i + 1][j];
                
                source.addNeighbor(north);
                source.addNeighbor(south);                
                source.addNeighbor(west);
                source.addNeighbor(east);
            }
        }
    }
    
    /**
     * Generates edges for each of the vertices that are parallel and perpendicular
     * to each other.
     */
    public void generateEdges() {
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                Vertex source = adjMatrix[i][j];
                Vertex west = (j == 0) ? null : adjMatrix[i][j - 1];
                Vertex east = (j == adjMatrix[i].length - 1) ? null : adjMatrix[i][j + 1];
                Vertex north = (i == 0) ? null : adjMatrix[i - 1][j];
                Vertex south = (i  == adjMatrix.length - 1) ? null : adjMatrix[i + 1][j];
                
                source.addEdge(north);
                source.addEdge(south);                
                source.addEdge(west);
                source.addEdge(east);
            }
        }
    }   

    /**
     * Gets the graphs adjacency matrix.
     * @return the adjacency matrix.
     */
    public Vertex[][] getAdjMatrix() {
        return adjMatrix;
    }

    /**
     * Gathers all of the edges of the graph and returns them in an ArrayList
     * @return an ArrayList of graph edges.
     */
    public ArrayList<Edge> getEdges() {
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i = 0; i < adjMatrix.length; i++){
            for(int j = 0; j < adjMatrix[i].length; j++){
                for(Edge edge : adjMatrix[i][j].getEdges()){
                    edges.add(edge);
                }  
            }
        }

        return edges;
    }

    /**
     * Gets the bounds of the graph.
     * @return the bounds of the graph.
     */
    public int getBounds() {
        return bounds;
    }

    /**
     * Gets the size of the graph.
     * @return the number of indexs in the adjacency matrix.
     */
    public int getSize() {
        return bounds * bounds;
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
