package maze;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class EdgeTest {
    Vertex testSource = new Vertex(0);
    Vertex testSource1 = new Vertex(1);
    Vertex testDestination = new Vertex(2);
    Edge testEdge = new Edge(testSource, testDestination);
    Edge testEdge1 = new Edge(null, null);
    Edge testEdge2 = new Edge(testSource, testDestination);
    Edge testEdge3 = new Edge(testSource1, testDestination);



    @Test
    void testGetSource() {
        assertEquals(testEdge.getSource(), testSource);
    }

    @Test
    void testGetDestination() {
        assertEquals(testEdge.getDestination(), testDestination);
    }

    @Test
    void testToString() {
        assertEquals("0--2", testEdge.toString());
    }

    @Test
    void testEquals(){
        assertFalse(testEdge.equals(testEdge1));
        assertTrue(testEdge.equals(testEdge2));
        assertFalse(testEdge.equals(testEdge3));
    }    
}