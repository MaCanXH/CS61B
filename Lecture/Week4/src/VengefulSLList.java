import org.w3c.dom.Node;

public class VengefulSLList<Item> extends SLList<Item>{
    SLList<Item> deletedItem;

    public VengefulSLList(){
        super();
        deletedItem = new SLList<>();
    }

    public VengefulSLList(Item x){
        super(x);
        deletedItem = new SLList<>();
    }

    public Item removeLast(){
        Item x = super.removeLast();
        deletedItem.addLast(x);
        return x;
    }
    /* Prints deleted items. */
    public void printLostItem(){
        deletedItem.print();
    }
}