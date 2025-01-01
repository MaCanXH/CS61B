import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K, V> implements Map61B<K, V> {

    private int initialSize;
    private double loadFactor;
    private int size;
    private ArrayList<itemPair>[] elements;
    private HashSet<K> keySet = new HashSet<>();

    private class itemPair {
        private K key;
        private V value;

        private itemPair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, 0.75);
    }

    public MyHashMap(int initialSize, double loadFactor) {
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
        this.size = 0;
        elements = new ArrayList[initialSize];
        for (int i = 0; i < initialSize; i++) {
            elements[i] = new ArrayList<>();
        }
    }

    @Override
    public void clear() {
        this.initialSize = 16;
        this.loadFactor = 0.75;
        this.size = 0;
        elements = new ArrayList[initialSize];
        for (int i = 0; i < initialSize; i++) {
            elements[i] = new ArrayList<>();
        }
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int index = Math.abs(key.hashCode() % elements.length);
        if (elements[index].isEmpty()) {
            return null;
        }

        for (itemPair i : elements[index]) {
            if (i.key.equals(key)) {
                return i.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        if ((double) size / initialSize >= loadFactor) {
            resize(initialSize * 2);
        }

        int index = Math.abs(key.hashCode() % elements.length);
        if (elements[index].isEmpty()) {
            size++;
            elements[index].add(new itemPair(key, value));
            keySet.add(key);
        } else {
            for (itemPair i : elements[index]) {
                if (i.key.equals(key)) {
                    i.value = value;
                    return;
                }
            }
            size++;
            elements[index].add(new itemPair(key, value));
            keySet.add(key);
        }
    }

    private void resize(int cap) {
        MyHashMap<K, V> temp = new MyHashMap<>(cap);
        for (K key : keySet()) {
            temp.put(key, get(key));
        }
        initialSize = temp.initialSize;
        size = temp.size;
        elements = temp.elements;
    }

    @Override
    public Set<K> keySet() {
        return keySet;
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
        return keySet.iterator();
    }
}
