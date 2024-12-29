import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnionFind {

    @Test
    public void testUnion() {
        UnionFind test1 = new UnionFind(10);
        test1.union(4, 5);
        assertTrue(test1.connected(4, 5));
        test1.union(1, 3);
        test1.union(4, 1);
        assertTrue(test1.connected(5, 3));
        assertFalse(test1.connected(2, 4));
    }

    @Test
    public void testSize(){
        UnionFind test1 = new UnionFind(10);
        test1.union(2, 4);
        test1.union(3, 4);
        test1.union(5, 4);
        test1.union(6, 4);
        assertEquals(5, test1.sizeOf(6));
    }

    @Test
    public void testFind(){
        UnionFind test1 = new UnionFind(10);
        test1.union(4, 5);
        test1.union(4, 7);
        test1.union(4, 1);
        test1.union(4, 8);
        test1.union(4, 3);
        assertEquals(5, test1.find(8));
        assertEquals(5, test1.find(3));
    }

    @Test
    public void testParent(){
        UnionFind test1 = new UnionFind(10);
        test1.union(2, 4);
        test1.union(4, 5);
        test1.union(5, 7);
        test1.union(7, 1);
        assertEquals(4, test1.parent(5));
        assertEquals(4, test1.parent(1));
        assertEquals(4, test1.parent(2));
        assertEquals(-1, test1.parent(8));
    }
}
