//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    }

    public static boolean dup1 (int[] A){
        for (int i = 0; i < A.length; i++){
            for (int j = i; j < A.length; j++){
                if (A[i] == A[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dup2 (int[] A){
        for (int i = 0; i < A.length - 1; i++){
            if (A[i] == A[i + 1]){
                return true;
            }
        }
        return false;
    }
}