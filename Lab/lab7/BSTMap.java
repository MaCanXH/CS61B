import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node leftChild;
        private Node rightChild;
        private int size;

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BSTMap() {
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument in containKey() is null.");
        }
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument in get() is null.");
        }
        if (root == null) {
            return null;
        }
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node.val;
        } else if (key.compareTo(node.key) < 0) {
            return get(node.leftChild, key);
        } else {
            return get(node.rightChild, key);
        }
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("arguments in put() are nulls.");
        }
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.leftChild = put(node.leftChild, key, value);
        }
        else if (cmp > 0) {
            node.rightChild = put(node.rightChild, key, value);
        }
        else node.key = key;
        node.size = 1 + size(node.leftChild) + size(node.rightChild);
        return node;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] art){
        BSTMap<String, Integer> test = new BSTMap<>();
        test.put("hi", 1);
        System.out.println(test.get("hi"));
        System.out.println(test.containsKey("hi"));
    }
}
