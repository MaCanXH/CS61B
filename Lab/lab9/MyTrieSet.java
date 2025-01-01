import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTrieSet implements TrieSet61B {

    private Node root;

    private class Node {
        private boolean isKey;
        private HashMap<Character, Node> map;

        public Node(boolean k) {
            this.isKey = k;
            this.map = new HashMap<>();
        }
    }

    public MyTrieSet() {
        root = new Node(false);
    }

    @Override
    public void clear() {
        root = new Node(false);
    }

    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node curr = find(key);
        if (curr == null) {
            return false;
        }
        return curr.isKey;
    }

    private Node find(String key){
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                return null;
            }
            curr = curr.map.get(c);
        }
        return curr;
    }

    @Override
    public void add(String key) {
        if (key == null || key.length() < 1) {
            return;
        }
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new Node(false));
            }
            curr = curr.map.get(c);
        }
        curr.isKey = true;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        if (prefix == null || prefix.length() < 1){
            throw new IllegalArgumentException();
        }
        Node curr = find(prefix);
        List<String> keys = new ArrayList<>();
        return keysWithPrefix(prefix, keys, curr);
    }

    private List<String> keysWithPrefix(String s, List<String> keys, Node curr) {
        if (curr == null) {
            return keys;
        }
        for (char c : curr.map.keySet()){
            if (curr.map.get(c).isKey){
                keys.add(s + c);
            }
            keysWithPrefix(s + c, keys, curr.map.get(c));
        }
        return keys;
    }

    @Override
    public String longestPrefixOf(String key) {
        throw new UnsupportedOperationException();
    }
}
