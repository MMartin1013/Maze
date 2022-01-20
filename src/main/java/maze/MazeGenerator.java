package maze;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class that generates mazes using a randomized depth first search on 
 * the graph class.
 * @author Manolo Martin.
 */
public class MazeGenerator {
    /**
     * Used to choose the next path in the randomized
     * depth first search.
     */
    private Random rand = new Random();

    /**
     * Keeps track of what vertices have been visited
     * in the depth first search.
     */
    private boolean[] visited;

    /**
     * Contains the connection points/paths in the maze.
     */
    private ArrayList<Edge> mazeEdges;

    /**
     * Dimensions of the graph.
     */
    private int bounds;

    /**
     * The graph the maze is built from.
     */
    private Graph graph;

    /**
     * Creates a new mazegenerator with a graph of default bounds
     * and initializes the mazeedges and bounds field.
     */
    public MazeGenerator() {
        graph = new Graph();
        bounds = graph.getBounds();
        mazeEdges = new ArrayList<>();
    }
    
    /**
     * Creates a new mazegenerator with a graph of specified bounds.
     * @param bounds
     */
    public MazeGenerator(int bounds) {
        graph = new Graph(bounds);
        this.bounds = bounds;
        mazeEdges = new ArrayList<>();
    }

    /**
     * Changes the bounds of the mazegenerators graph and clears mazeEdges.
     * @param bounds of the new graph.
     */
    public void changeBounds(int bounds) {
        graph = new Graph(bounds);
        this.bounds = bounds;
        mazeEdges.clear();
    }

    /**
     * Generates a new maze and deletes the old one 
     * if there was an old maze.
     */
    public void generateMaze(){
        mazeEdges.clear();
        graph = new Graph(bounds);
        makeST();
    }
    
    /**
     * Helper method for generatemaze that starts off the depth first search
     * using the vertex at the beginning of the adjacency matrix and initializes
     * the visited array.
     */
    public void makeST(){
        Vertex[][] matrix = graph.getAdjMatrix();
        Vertex startVertex = matrix[0][0];
        visited = new boolean[graph.getSize()];
        DFS(startVertex);
    }

    /**
     * Randomized depth first search that chooses a random neighbor to visit from the 
     * start vertex and adds that edge to the maze edge list and adds a connector edge generated
     * for the destination vertex. 
     * @param vertex the current vertex.
     */
    private void DFS(Vertex vertex) {
        visited[vertex.getId()] = true;
        ArrayList<Vertex> neighbors = vertex.getNeighbors();
        Vertex nextVertex = null;
        int randNum;

        for(int i = 0; i < neighbors.size(); i++) {
            if(visited[neighbors.get(i).getId()]) {
                neighbors.remove(i);
                i--;
            }
        }

        if(!neighbors.isEmpty()){
            randNum = rand.nextInt(neighbors.size());
            if(!visited[neighbors.get(randNum).getId()]){
                nextVertex = neighbors.get(randNum);
                neighbors.remove(randNum);
            }
        }
        
        while(nextVertex != null) {
            Edge connector = new Edge(vertex, nextVertex);
            Edge reverseConnector = new Edge(nextVertex, vertex);
            mazeEdges.add(connector);
            mazeEdges.add(reverseConnector);
            vertex.addEdge(connector);
            nextVertex.addEdge(reverseConnector);

            DFS(nextVertex);
            nextVertex = null;

            for(int i = 0; i < neighbors.size(); i++) {
                if(visited[neighbors.get(i).getId()]) {
                    neighbors.remove(i);
                    i--;
                }
            }

            if(!neighbors.isEmpty()){
                randNum = rand.nextInt(neighbors.size());
                if(!visited[neighbors.get(randNum).getId()]){
                    nextVertex = neighbors.get(randNum);
                    neighbors.remove(randNum);
                }
            }
        }
    }

    /**
     * Gets the mazegenerators graph.
     * @return the mazegenerators graph.
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * Gets the dimensions of the graph.
     * @return the bounds.
     */
    public int getBounds() {
        return bounds;
    }

    /**
     * Gathers the current maze up in a string form using a string builder.
     * @return the maze in string form.
     */
    public String showMaze(){
        StringBuilder str = new StringBuilder();
        Vertex[][] adjMatrix = graph.getAdjMatrix();

        str.append(" ");
        for(int i = 0; i < getBounds(); i++) {
            str.append("_ ");
        } 
        str.append("\n");

        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix[i].length; j++) {
                ArrayList<Edge> edges = adjMatrix[i][j].getEdges();
                boolean left = false;
                boolean bottom = false;
                for(Edge edge : edges){
                    if(edge.getSource().getId() - 1 == edge.getDestination().getId()) {
                        left = true;
                    }else if(edge.getSource().getId() + adjMatrix.length == edge.getDestination().getId()) {
                        bottom = true;
                    }
                }

                if(left && bottom) {
                    str.append("  ");
                }else if(left) {
                    str.append(" _");
                }else if(bottom){
                    str.append("| ");
                }else {
                    str.append("|_");
                }
            }
            str.append("|\n");
        }
        str.append("\n");
        return str.toString();
    }
}