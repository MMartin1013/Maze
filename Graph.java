public class Graph {

    /**
     * Used to generate unique ids for the vertexes
     */
    public static int vertexCount = 0;

    private final int DEFAULT_BOUNDS = 5;

    /**
     * Holds all vertexes
     */
    private Vertex[][] adjMatrix;
    
    /**
     * Default Constructor.
     */
    public Graph() {
        adjMatrix = new Vertex[DEFAULT_BOUNDS][DEFAULT_BOUNDS];
        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = new Vertex(vertexCount++);
            }
        }
        
        generateEdges();
    }

    public Graph(int bounds) {
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
                Vertex W = (j == 0) ? null : adjMatrix[i][j - 1];
                Vertex E = (j == adjMatrix[i].length - 1) ? null : adjMatrix[i][j + 1];
                Vertex N = (i == 0) ? null : adjMatrix[i - 1][j];
                Vertex S = (i  == adjMatrix.length - 1) ? null : adjMatrix[i + 1][j];
                source.addEdge(N);
                source.addEdge(E);
                source.addEdge(W);
                source.addEdge(S);                
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        for(int i = 0; i < graph.adjMatrix.length; i++) {
            for(int j = 0; j < graph.adjMatrix[i].length; j++) {
                System.out.print(graph.adjMatrix[i][j] + " ");
            }
            System.out.println();
        }


        for(int i = 0; i < graph.adjMatrix.length; i++) {
            for(int j = 0; j < graph.adjMatrix[i].length; j++) {
                for(Edge edge : graph.adjMatrix[i][j].getEdges()) {
                    System.out.print(edge + " ");
                }
                System.out.println();
            }
        }
    }

}
