package maze;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MazeGenerator {
    private int[][] maze;
    Graph graph;

    
    public MazeGenerator() {
        graph = new Graph();
        //randomizeMatrix();
    }
    
    public MazeGenerator(int bounds) {
        graph = new Graph(bounds);
        //randomizeMatrix();
    }

    /*
    public void randomizeMatrix() {
        if(adjMatrix == null) return;
        
        for(int i = 0; i < adjMatrix.length; i++){
            for(int j = 0; j < adjMatrix.length; j++){
                int randNum = rand.nextInt(51);
                adjMatrix[i][j] = randNum;
            }
        }
    }
    */

    public void changeBounds(int bounds) {
        graph = new Graph(bounds);
    }

    public ArrayList<Edge> generateMST() {
        PriorityQueue<Edge> edges = graph.getEdges();
        ArrayList<Edge> mazeEdges = new ArrayList<>();
        boolean[] visited = new boolean[graph.getSize()];
        boolean allVisited = false;

        while(!allVisited){
            Edge edge = edges.remove();

            if(!visited[edge.getDestination().getId()]){
                mazeEdges.add(edge);
                visited[edge.getSource().getId()] = true;
                visited[edge.getDestination().getId()] = true;
            }

            for(int i = 0; i < visited.length; i++) {
                if(!visited[i]) {
                    break;
                }else if(visited[i] && i == visited.length -1) {
                    allVisited = true;
                    break;
                }
            }

            System.out.println(edge);
            for(int i = 0; i < visited.length; i++){
                System.out.print(i + ": " +visited[i] + " ");
            }

            System.out.println();
        }

        return mazeEdges;
        
    }
}