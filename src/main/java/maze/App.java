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
        MazeGenerator gen = new MazeGenerator(6);

        System.out.println(gen.getGraph());

        gen.showMaze();
        
        gen.makeST();

        System.out.println();

        gen.showMaze();;
    
        gen.generateMaze();

        gen.showMaze();
        
    }
}
