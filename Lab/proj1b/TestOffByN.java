import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    CharacterComparator OffByN = new OffByN(5);

    @Test
    public void testOffByN(){
        assertTrue(OffByN.equalChars('a', 'f'));
        assertTrue(OffByN.equalChars('f', 'a'));
        assertFalse(OffByN.equalChars('h', 'f'));
    }
}
