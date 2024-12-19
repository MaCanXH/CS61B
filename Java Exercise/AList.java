

class ArrayList{
    static void main(){
        AList n = new AList();
        n.addLast(19);
        n.addLast(12);
        n.addLast(4);
        n.addLast(9);
        n.addLast(9);
        n.addLast(20);
        System.out.println(n.size());
        System.out.println(n.getLast());
        System.out.println(n.get(2));
        System.out.println(n.removeLast());
        System.out.println(n.getLast());
        System.out.println(n.size());
    }
}


public class AList<Item> {
    private Item[] item;
    private int size;
    /** Creates an empty list. */
    public AList() {
        this.item = (Item[]) new Object[100];
        this.size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if(size == item.length){
            Resize(size * 2);
        }
        this.item[size] = x;
        this.size++;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return this.item[size - 1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return this.item[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        Item x = getLast();
        this.item[size - 1] = null;
        this.size--;
        if((double)size / item.length <= 0.25)
        {
            Resize(item.length / 2);
        }
        return x;
    }

    private void Resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(item, 0, a, 0, size);
        item = a;
    }
} 