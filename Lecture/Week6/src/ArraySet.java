import java.util.*;

public class ArraySet<T> implements Iterable<T>{

    private T[] item;
    int size;

    public ArraySet() {
        item = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size(); i++){
            if (item[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null){
            throw new IllegalArgumentException("Cannot input null item.");
        }
        if (contains(x)){
            return;
        }
        item[size] = x;
        size++;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }


    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
    @Override
    public Iterator<T> iterator() {
        return new ArraysetIterator();
    }

    private class ArraysetIterator implements Iterator<T>{

        private int wizPos;

        public ArraysetIterator(){
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T nextItem = item[wizPos];
            wizPos++;
            return nextItem;
        }

    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++){
            sb.append(item[i]);
            sb.append(", ");
        }
        sb.append(item[size - 1]);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if (this.getClass() != other.getClass()){
            return false;
        }
        if (other == null){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (this.size() != o.size()){
            return false;
        }
        for (T item : o){
            if (!this.contains(item)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
//        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        for (String k : s){
            System.out.println(k);
        }
        System.out.println(s);

        ArraySet<String> s2 = new ArraySet<>();
        s2.add("horse");
        s2.add("fish");
        s2.add("house");

        List<Integer> s3 = new ArrayList<>();
        s3.add(1);

        ArraySet<String> s4 = new ArraySet<>();
        s4.add("this");
        s4.add("is");
        s4.add("it");

        System.out.println(s.equals(s));
        System.out.println(s.equals(s2));
        System.out.println(s.equals(s3));
        System.out.println(s.equals(s4));

    }
}
