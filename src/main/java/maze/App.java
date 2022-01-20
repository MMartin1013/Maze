package maze;

/**
 * Runs all the files in the maze package.
 */
public final class App {
    private App() {

    }

    /**
     * Runs the app.
     */
    public static void start(){
        new Gui();
    }

    /**
     * Main method of the program.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App.start();
    }
}
