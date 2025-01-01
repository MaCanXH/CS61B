public class TrieSet{
    private static final int R = 128; // ASCII
    private Node root; // root of trie

    private static class Node{
//        private char ch; represented by the link position
        private boolean isKey;
        private DataIndexedCharMap next;

        private Node(/*char c,*/ boolean blue, int R) {
//            ch = c;
            isKey = blue;
            next = new DataIndexedCharMap(R);
        }
    }
}
