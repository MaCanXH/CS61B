package Disc03;

public class DisArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        printArray(arr);
        int[] A = insert(arr, 9, 3);
        printArray(A);
        int[] B = insert(arr, 7, 10);
        printArray(B);
        reverse(arr);
        printArray(arr);
        int[] C = replicate(new int[]{4, 5, 6});
        printArray(C);
    }

    public static int[] insert(int[] arr, int item, int position) {
        int[] newArr = new int[arr.length + 1];
//        if (position >= arr.length){
//            System.arraycopy(arr, 0, newArr, 0, arr.length);
//            newArr[newArr.length - 1] = item;
//            return newArr;
//        }
        position = Math.min(position, arr.length);
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        newArr[position] = item;
        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void reverse(int[] arr) {
        int count = arr.length / 2;
        for (int i = 0; count > 0; count--, i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static int[] replicate(int[] arr) {
        int newLength = 0;
        for (int i = 0; i < arr.length; i++) {
            newLength += arr[i];
        }
        int[] newArr = new int[newLength];
        int Pos = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                newArr[Pos] = arr[i];
                Pos++;
            }
        }
        return newArr;
    }
}
