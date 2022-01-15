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
        MazeGenerator gen = new MazeGenerator();

        System.out.println(graph);

        graph.showEdges();

        //System.out.println(graph.getEdges());
        
    }
}
