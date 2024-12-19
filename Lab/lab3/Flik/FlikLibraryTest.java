import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class FlikLibraryTest{
    @Test
    public void LibraryTest(){
        int A = 127;
        int exp = 127;
        assertTrue(Flik.isSameNumber(A, exp));
    }
}
