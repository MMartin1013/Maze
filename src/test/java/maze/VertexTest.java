package maze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class VertexTest{
    Vertex testVertex1 = new Vertex(10);
    Vertex testVertex2 = new Vertex(10);
    Vertex testVertex3 = new Vertex(15);
    Vertex testVertex4 = null;
    Edge testEdge = new Edge(testVertex1, testVertex2);
    Edge testEdge1 = new Edge(testVertex3, testVertex2);

    @Test
    void testGetId(){
        assertEquals(10, testVertex1.getId());
        assertEquals(15, testVertex3.getId());
    }

    @Test
    void testAddEdge(){
        assertTrue(testVertex1.addEdge(testVertex2));
        assertTrue(testVertex1.getEdges().contains(testEdge));
        assertTrue(testVertex1.getNeighbors().contains(testVertex2));
        
        assertFalse(testVertex1.addEdge(testVertex4));
        
        assertTrue(testVertex3.addEdge(testEdge1));
        assertTrue(testVertex3.getEdges().contains(testEdge1));
        assertTrue(testVertex3.getNeighbors().contains(testVertex2));
    }

    @Test
    void testRemoveEdge(){
        assertFalse(testVertex1.removeEdge(testEdge1));
        testVertex3.addEdge(testEdge1);
        assertTrue(testVertex3.removeEdge(testEdge1));

        assertFalse(testVertex3.getEdges().contains(testEdge1));
    }
    
    @Test
    void testAddNeighbor(){
        assertFalse(testVertex1.addNeighbor(testVertex4));
        
        assertTrue(testVertex3.addNeighbor(testVertex1));
        assertTrue(testVertex3.getNeighbors().contains(testVertex1));

    }
    @Test
    void testCompareTo(){
        assertEquals(0, testVertex1.compareTo(testVertex2));
        assertTrue(0 > testVertex1.compareTo(testVertex3));
        assertTrue(0 < testVertex3.compareTo(testVertex1));
    }

    @Test
    void testEquals(){
        assertEquals(testVertex1, testVertex1);
        assertEquals(testVertex1,testVertex2);
        assertNotEquals(testVertex1,testEdge);
        assertNotEquals(testVertex1,testVertex3);
    }

    @Test
    void testToString() {
        assertEquals("10",testVertex1.toString());
    }
    
}
