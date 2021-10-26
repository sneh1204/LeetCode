package sample;

public class q2 {

    // 0 -> N then add N -> 0 Add recursively

    public static int helper(int cur_idx, int prev_idx, int[] arr, int answer){
        if(cur_idx == -1) return answer;

        if(cur_idx == arr.length - 1 || prev_idx > cur_idx) return helper(cur_idx - 1, cur_idx, arr, arr[cur_idx] + answer);

        return helper(cur_idx + 1, cur_idx, arr, answer);
    }

    public static void main(String[] args) {
        System.out.println(helper(0, 0, new int[]{1,2,3,4,5}, 0));
    }

}
