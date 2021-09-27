import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 3SUM
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 */
public class q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();

        List<List<Integer>> ret = new ArrayList<>();
        HashMap<Integer, Integer> store = new HashMap<>();
        //for(int i = 0; i < nums.length; i++){

        //}
        return ret;
    }

}
