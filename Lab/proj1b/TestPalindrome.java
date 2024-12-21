import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsParlindrome() {
        boolean test1 = palindrome.isPalindrome("cat");
        boolean test2 = palindrome.isPalindrome("racecar");
        boolean test3 = palindrome.isPalindrome("Noon");
        boolean test4 = palindrome.isPalindrome("a");
        boolean test5 = palindrome.isPalindrome("");
        assertFalse(test1);
        assertTrue(test2);
        assertFalse(test3);
        assertTrue(test4);
        assertTrue(test5);
    }

    @Test
    public void testOfByOnePalindrome() {
        assertTrue(palindrome.isPalindrome("flame", new OffByOne()));
        assertFalse(palindrome.isPalindrome("doggy", new OffByOne()));
        assertFalse(palindrome.isPalindrome("Flame", new OffByOne()));
        assertTrue(palindrome.isPalindrome("k", new OffByOne()));
        assertTrue(palindrome.isPalindrome("", new OffByOne()));
    }
} /*    Uncomment this class once you've created your Palindrome class. */