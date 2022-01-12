package maze;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Graph graph = new Graph();

        for(int i = 0; i < graph.getAdjMatrix().length; i++) {
            for(int j = 0; j < graph.getAdjMatrix()[i].length; j++) {
                System.out.print(graph.getAdjMatrix()[i][j] + " ");
            }
            System.out.println();
        }


        for(int i = 0; i < graph.getAdjMatrix().length; i++) {
            for(int j = 0; j < graph.getAdjMatrix()[i].length; j++) {
                for(Edge edge : graph.getAdjMatrix()[i][j].getEdges()) {
                    System.out.print(edge + " ");
                }
                System.out.println();
            }
        }
    }
}
