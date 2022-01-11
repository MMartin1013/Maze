public class Graph {
    /**
     * Used to generate unique ids for the vertexes
     */
    public static int vertexCount = 0;

    private final int DEFAULT_BOUNDS = 10;

    /**
     * Holds all vertexes
     */
    private Vertex[][] adjMatrix;
    
    /**
     * Defalt
     */
    public Graph() {
        adjMatrix = new Vertex[DEFAULT_BOUNDS][DEFAULT_BOUNDS];
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = new Vertex(vertexCount++);
            }
        }

        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                if(i == 0 && j == 0) {

                }else if(i == 0){

                }else if(j == 0) {

                }else if(i == adjMatrix.length && j == adjMatrix.length){

                }else if(i == adjMatrix.length){

                }else if(j == adjMatrix.length){

                }else {

                }
            }
        }
    }

    public Graph(int bounds) {
        adjMatrix = new Vertex[bounds][bounds]; 

        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = new Vertex(vertexCount++);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        for(int i = 0; i < graph.adjMatrix.length; i++) {
            for(int j = 0; j < graph.adjMatrix[i].length; j++) {
                System.out.print(graph.adjMatrix[i][j].getId() + " ");
            }
            System.out.println();
        }
    }

}
