package Map61B;

import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;
import java.util.List;

public class ArrayMap<K, V> implements Map61B<K, V> {
    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap(){
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        int size = 0;
    }

    private int keyIndex(K key){
        for (int i = 0; i < size; i++){
            if (keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key){
        int index = keyIndex(key);
//        if (index > -1){
//            return true;
//        }
//        return false;
        return index > -1;
    }

    @Override
    public V get(K key) {
        int index = keyIndex(key);
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1){
            keys[size] =key;
            values[size] = value;
            size++;
            return;
        }
        values[index] = value;
    }

    @Override
    public List<K> keys() {
        List<K> keylist = new ArrayList<>();
        for (int i = 0; i < size; i++){
            keylist.add(keys[i]);
        }
        return keylist;
    }

    public static void main (String args[]){
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 6);
        m.put("house", 0);
    }
}
