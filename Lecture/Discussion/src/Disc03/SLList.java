package Disc03;

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        if (first == null || position == 0){
            addFirst(item);
            return;
        }
        IntNode ptr = first;
        for (int i = 1; i < position; i++){
            if (ptr.next == null){
                break;
            }
            ptr = ptr.next;
        }
        ptr.next = new IntNode(item, ptr.next);
//        if (first == null || position == 0) {
//            addFirst(item);
//            return;
//        }
//        IntNode currentNode = first;
//        while (position > 1 && currentNode.next != null) {
//            position--;
//            currentNode = currentNode.next;
//        }
//        IntNode newNode = new IntNode(item, currentNode.next);
//        currentNode.next = newNode;
    }
}
