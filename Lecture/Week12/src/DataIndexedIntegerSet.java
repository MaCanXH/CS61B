public class DataIndexedIntegerSet {
    private boolean[] present;

    public DataIndexedIntegerSet() {
        present = new boolean[200000000];
    }

    public void add(int x) {
        present[x] = true;
    }

    public boolean contains(int x) {
        return present[x];
    }
}