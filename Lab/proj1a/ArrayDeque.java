public class ArrayDeque<T> {
    T[] ArrDeque;
    int firstIdx;
    int lastIdx;
    int size;

    public ArrayDeque() {
        ArrDeque = (T[]) new Object[8];
        firstIdx = 0;
        lastIdx = 0;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        ArrDeque = (T[]) new Object[other.ArrDeque.length];
        for (int i = 0; i < other.ArrDeque.length; i++) {
            ArrDeque[i] = (T) other.ArrDeque[i];
        }
        size = other.size;
        firstIdx = other.firstIdx;
        lastIdx = other.lastIdx;
    }

    public void addFirst(T item) {
        if (item == null) {
            return;
        }
        if (size == ArrDeque.length) {
            resize(size * 2);
        }
        firstIdx = IndexCheck(firstIdx - 1);
        ArrDeque[firstIdx] = item;
        size++;
        if (size == 1) {
            lastIdx = firstIdx;
        }
    }

    public void addLast(T item) {
        if (item == null) {
            return;
        }
        if (size == ArrDeque.length) {
            resize(size * 2);
        }
        lastIdx = IndexCheck(lastIdx + 1);
        ArrDeque[lastIdx] = item;
        size++;
        if (size == 1) {
            firstIdx = lastIdx;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (lastIdx > firstIdx) {
            for (int i = firstIdx; i <= lastIdx; i++) {
                System.out.print(ArrDeque[i] + " ");
            }
            return;
        }
        for (int i = firstIdx; i < ArrDeque.length; i++) {
            System.out.print(ArrDeque[i] + " ");
        }
        for (int j = 0; j <= lastIdx; j++) {
            System.out.print(ArrDeque[j] + " ");
        }
    }

    public T removeFIrst() {
        if (ArrDeque[firstIdx] == null) {
            return null;
        }
        T output = ArrDeque[firstIdx];
        ArrDeque[firstIdx] = null;
        firstIdx = IndexCheck(firstIdx + 1);
        size--;
        if ((double) size / ArrDeque.length <= 0.25) {
            resize(ArrDeque.length / 2);
        }
        return output;
    }

    public T removeLast() {
        if (ArrDeque[lastIdx] == null) {
            return null;
        }
        T output = ArrDeque[lastIdx];
        ArrDeque[lastIdx] = null;
        lastIdx = IndexCheck(lastIdx - 1);
        size--;
        if ((double) size / ArrDeque.length <= 0.25) {
            resize(ArrDeque.length / 2);
        }
        return output;
    }

    public T get(int index) {
        int idx = IndexCheck(firstIdx + index);
        return ArrDeque[idx];
    }

    private int IndexCheck(int i) {
        if (i < 0) {
            return ArrDeque.length + i;
        } else if (i >= ArrDeque.length) {
            return i - ArrDeque.length;
        }
        return i;
    }

    private void resize(int capacity) {
        T[] newArr = (T[]) new Object[capacity];
        int counter = 0;
        if (lastIdx > firstIdx) {
            for (int i = firstIdx; i <= lastIdx; i++) {
                newArr[counter] = ArrDeque[i];
                counter++;
            }
            ArrDeque = newArr;
            firstIdx = 0;
            lastIdx = size - 1;
            return;
        }
        for (int i = firstIdx; i < ArrDeque.length; i++) {
            newArr[counter] = ArrDeque[i];
            counter++;
        }
        for (int i = 0; i <= lastIdx; i++) {
            newArr[counter] = ArrDeque[i];
            counter++;
        }
        ArrDeque = newArr;
        firstIdx = 0;
        lastIdx = size - 1;
    }
}
