package Disc04;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSListDisc04 {
    @Test
    public void test(){
        SList A = new SList();
        A.insertFront(1);
        A.insertFront(2);
        SList B = new SList();

        assertEquals("2", A.getFront());
        assertNotEquals("1", A.getFront());
        assertTrue(B.getFront() == -1);
    }
}
