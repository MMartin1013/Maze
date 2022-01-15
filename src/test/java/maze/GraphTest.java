package maze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GraphTest {
    Graph testGraph = new Graph();
    Graph testGraph1 = new Graph(10);
    Vertex[][] testMatrix = new Vertex[5][5];
    Vertex[][] testMatrix1 = new Vertex[10][10];

    @Test
    void testGetAdjMatrix() {
        int count = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                testMatrix[i][j] = new Vertex(count++);
                assertEquals(testMatrix[i][j], testGraph.getAdjMatrix()[i][j]);
             }
        }

        count = 0;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                testMatrix1[i][j] = new Vertex(count++);
                assertEquals(testMatrix1[i][j], testGraph1.getAdjMatrix()[i][j]);
             }
        }
    }
}
