package sample.fbprep;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i > 0 && nums[i - 1] >= nums[i])
            i--;

        if(i > 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i-1])
                j--;

            swap(nums, i - 1, j);
        }

        // reverse
        int end = nums.length - 1;
        while(i < end){
            swap(nums, i++, end--);
        }
    }

    public static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 3, 3, 0};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
