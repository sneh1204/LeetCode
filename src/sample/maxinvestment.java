package sample;

public class maxinvestment {

    public static int investment(int n, int[][] rounds) {
        long[] invest = new long[n]; // create array of investment with initial value = 0 for each asset
        for (int[] round : rounds) { // loop thru all rounds to update contribution amount in the investment list
            // invest[round[0] - 1] -> (Left - 1) index
            // invest[round[1]] -> (right) index
            //round[2] -> contribution amount

            invest[round[0] - 1] += round[2];  // update investment contribution amount of the (left - 1) index
            if (round[1] < n) { // skip updating contribution amount if right index is > n
                invest[round[1]] -= round[2];  // update investment contribution amount of the right index
            }
        }
        int cur = 0, max = 0;
        for (long value : invest) {// update investment contribution amount for each asset after the last round
            cur += value; // getting the current value at each index
            max = Math.max(cur, max); // keep track of the max value in the investment array
        }
        return max;
    }

    public static void main(String[] args) {
       System.out.println(investment(5, new int[][]{{1,2,10}, {2,4,5}, {3,5,12}, {2, 3, 7}})); // 24
    }
}
