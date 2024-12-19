public class Sort{
    /* Sorts strings destructively. */
    public static void sort(String[] x){
//        find the smallest item
//        move it to the front
//        selection sort the rest (using recursion?)
        sort(x, 0);
    }

    /* Sorts strings destructively starting from item start. */
    private static void sort(String[] x, int start){
        if (start == x.length){
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    /* Returns the smallest string in x. */
    public static int findSmallest(String[] x, int start){
        int smallestIndex = start;
        for (int i = start; i < x.length; i++){
            if (x[i].compareTo(x[smallestIndex]) < 0){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
