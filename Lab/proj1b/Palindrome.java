public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> resList = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            resList.addLast(word.charAt(i));
        }
        return resList;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> list = wordToDeque(word);
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            if (!list.removeFirst().equals(list.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> list = wordToDeque(word);
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            if (!cc.equalChars(list.removeFirst(), list.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

