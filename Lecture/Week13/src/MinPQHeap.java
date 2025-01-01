public class MinPQHeap<Item extends Comparable<Item>> implements MinPQ<Item> {
    @Override
    public void add(Item x) {

    }

    @Override
    public Item getSmallest() {
        return null;
    }

    @Override
    public Item removeSmallest() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
//
//    Approach 1a
//    public class Tree1A<Key> {
//        Key k;
//        Tree1A left;
//        Tree1A middle;
//        Tree1A right;
//    }

//    Approach 1b
//    public class Tree1B<Key> {
//        Key k;
//        Tree1B[] children;
//    }

//    Approah 1c
//    public class Tree1C<Key> {
//        Key k;
//        Tree1C child;
//        Tree1C sibling;
//    }

//    Approach 2
//    public class Tree2<Key> {
//        Key[] keys;
//        int[] parents;
//    }

//    Approach 3
//    public class Tree3<Key> {
//        Key[] keys;
//
//        public void swim(int k) {
//            if(keys[parent(k)] > keys[k]){
//                swap(parent(k), k);
//                swim(parent(k));
//            }
//        }
//
//        private int parent(int k){
//            return (k - 1) / 2;
//        }
//
//        private void swap(int p, int k){
//            Key temp = keys[p];
//            keys[p] = keys[k];
//            keys[k] = temp;
//        }
//    }
}
