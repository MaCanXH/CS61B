public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        LinkedListDeque<T> newList = new LinkedListDeque<>();
        Node ptr = other.sentinel.next;
        while (ptr != other.sentinel) {
            newList.addFirst(ptr.item);
            ptr = ptr.next;
        }
    }

    public void addFirst(T item) {
        Node newItem = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = newItem;
        sentinel.next = newItem;
        size++;
    }

    public void addLast(T item) {
        Node newItem = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = newItem;
        sentinel.prev = newItem;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel){
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        Node remove = sentinel.next;
        sentinel.next = remove.next;
        remove.next.prev = sentinel;
        size--;
        return remove.item;
    }

    public T removeLast() {
        Node remove = sentinel.prev;
        sentinel.prev = remove.prev;
        remove.prev.next = sentinel;
        size--;
        return remove.item;
    }

    public T get(int index) {
        int counter = 0;
        Node ptr = sentinel.next;
        while (counter < index) {
            ptr = ptr.next;
            counter++;
        }
        return ptr.item;
    }

    public T getRecursive(int index) {
        Node ptr = sentinel.next;
        return RecursionGet(ptr, index - 1, 0);
    }

    private T RecursionGet(Node ptr, int index, int count) {
        if (index == count) {
            return ptr.item;
        }
        return RecursionGet(ptr, index, count + 1);
    }
}
