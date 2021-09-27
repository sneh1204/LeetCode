package F450;

import java.util.Arrays;

public class q1 {

    public static int[] reverse(int[] A){
        if(A.length <= 1) return A;
        int[] rev = new int[A.length];
        for(int i = A.length-1; i >= 0; i--){
            rev[A.length - i - 1] = A[i];
        }
        return rev;
    }

    public static int[] reverseBySwap(int[] A){
        if(A.length <= 1) return A;
        for(int i = 0; i < A.length / 2; i++){
            int temp = A[i];
            A[i] = A[A.length - i - 1];
            A[A.length - i - 1] = temp;
        }
        return A;
    }

    public static void reverseByRecursion(int[] A, int i){
        if(A.length > 1 && i != A.length/2){
            int temp = A[i];
            A[i] = A[A.length - i - 1];
            A[A.length - i - 1] = temp;
            reverseByRecursion(A, ++i);
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 4, 1, 5, 0, 9};
        System.out.println(Arrays.toString(reverse(A)));
        System.out.println(Arrays.toString(reverseBySwap(A)));
        int[] B = new int[]{2, 3, 4, 1, 5, 0, 9};
        reverseByRecursion(B, 0);
        System.out.println(Arrays.toString(B));
    }

}
