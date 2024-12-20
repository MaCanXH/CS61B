package Disc04;

public class DMSList {
    private IntNode sentinel;

    public DMSList() {
        sentinel = new IntNode(-1000, null);
    }

    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }

        public int max() {
            return Math.max(item, next.max());
        }
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public int max() {
        return sentinel.next.max();
    }
}

