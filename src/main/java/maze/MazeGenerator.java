package maze;
import java.util.ArrayList;
import java.util.Random;

public class MazeGenerator {
    private ArrayList<Edge> mazeEdges;
    private int bounds;
    private Graph graph;
    private Random rand = new Random();
    private boolean[] visited;

    
    
    public MazeGenerator() {
        graph = new Graph();
        bounds = 5;
        mazeEdges = new ArrayList<>();
    }
    
    public MazeGenerator(int bounds) {
        graph = new Graph(bounds);
        this.bounds = bounds;
        mazeEdges = new ArrayList<>();
    }

    public void changeBounds(int bounds) {
        graph = new Graph(bounds);
        this.bounds = bounds;
        mazeEdges.clear();
        generateMaze();
    }

    public void generateMaze(){
        mazeEdges.clear();
        graph = new Graph(bounds);
        makeST();
    }

    public void makeST(){
        Vertex[][] matrix = graph.getAdjMatrix();
        Vertex startVertex = matrix[0][0];
        visited = new boolean[graph.getSize()];
        DFS(startVertex);
    }

    private void DFS(Vertex vertex) {
        visited[vertex.getId()] = true;
        ArrayList<Vertex> neighbors = (ArrayList<Vertex>)vertex.getNeighbors().clone();
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

    public Graph getGraph() {
        return graph;
    }

    public void showMaze(){
        graph.showEdges();
    }
}