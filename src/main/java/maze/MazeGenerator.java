package maze;
import java.util.Random;

public class MazeGenerator {
    private int[][] maze;
    private int[][] adjMatrix;
    private Random rand;

    
    public MazeGenerator() {
        rand = new Random();
        randomizeMatrix();
    }
    
    public MazeGenerator(int bounds) {
        adjMatrix = new int[bounds][bounds];
        rand = new Random();
        randomizeMatrix();
    }

    public void randomizeMatrix() {
        if(adjMatrix == null) return;
        
        for(int i = 0; i < adjMatrix.length; i++){
            for(int j = 0; j < adjMatrix.length; j++){
                int randNum = rand.nextInt(51);
                adjMatrix[i][j] = randNum;
            }
        }
        
    }

    public void changeBounds(int bounds) {
        adjMatrix = new int[bounds][bounds];
        randomizeMatrix();
    }


    public void createWalls() {
        
    }

    public void Kruskals() {
        
    }

    public static void main(String[] args) {
        MazeGenerator maze = new MazeGenerator();

        for(int i = 0; i < maze.adjMatrix.length; i++) {
            for(int j = 0; j < maze.adjMatrix[i].length; j++){
                System.out.print(maze.adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }   
    
}