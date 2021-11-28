package sample.epi.arrays;

import java.util.Arrays;

public class SortParity {

    public static int[] sortArrayByParity(int[] nums) {
        if(nums == null || nums.length < 2) return nums;

        // even - odd
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2){
                nums[left] += nums[right];
                nums[right] = nums[left] - nums[right];
                nums[left] -= nums[right];
            }
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{2, 3, 5, 4, 1})));
    }

}
