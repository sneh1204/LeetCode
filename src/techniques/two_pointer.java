package techniques;

import java.util.Arrays;

public class two_pointer {


    /**
     * BRUTE FORCE METHOD O(N^2)
     */
    private static int[] isPairSumBF(int[] A, int N, int X)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // as equal i and j means same element
                if (i == j)
                    continue;

                // pair exists
                if (A[i] + A[j] == X)
                    return new int[]{i, j};

                // as the array is sorted
                if (A[i] + A[j] > X)
                    break;
            }
        }

        // No pair found with given sum.
        return null;
    }

    // O(N) only for sorted array
    public static int[] isPairSum(int[] A, int X)
    {
        Arrays.sort(A);
        int N = A.length;
        // represents first pointer
        int i = 0;

        // represents second pointer
        int j = N - 1;

        while (i < j) {

            // If we find a pair
            if (A[i] + A[j] == X)
                return new int[]{i,j};

                // If sum of elements at current
                // pointers is less, we move towards
                // higher values by doing i++
            else if (A[i] + A[j] < X)
                i++;

                // If sum of elements at current
                // pointers is more, we move towards
                // lower values by doing j--
            else
                j--;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(isPairSum(new int[]{10, 8, 9, 7 , 6, 15, 16}, 13)));
    }

}
