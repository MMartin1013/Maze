package maze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class VertexTest{
    Vertex testVertex1 = new Vertex(10);
    Vertex testVertex2 = new Vertex(10);
    Vertex testVertex3 = new Vertex(15);
    Edge testEdge = new Edge(testVertex1, testVertex2, 10);

    @Test
    void testGetId(){
        assertEquals(10, testVertex1.getId());
    }

    @Test
    void testAddEdge(){
        assertTrue(testVertex1.addEdge(testVertex2));
        assertTrue(testVertex1.getEdges().contains(testEdge));
        assertFalse(testVertex1.addEdge(null));
    }

    @Test
    void testCompareTo(){
        assertEquals(0, testVertex1.compareTo(testVertex2));
        assertTrue(0 > testVertex1.compareTo(testVertex3));
        assertTrue(0 < testVertex3.compareTo(testVertex1));
    }

    @Test
    void testEquals(){
        assertTrue(testVertex1.equals(testVertex1));
        assertTrue(testVertex1.equals(testVertex2));
        assertFalse(testVertex1.equals(testEdge));
        assertFalse(testVertex1.equals(testVertex3));
    }

    @Test
    void testToString() {
        assertEquals("10",testVertex1.toString());
    }
    
}
