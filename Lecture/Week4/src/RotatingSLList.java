public class RotatingSLList<Item> extends SLList<Item>{
    public void rotateRight(){
        Item lastItem = removeLast();
        addFirst(lastItem);
    }
}

