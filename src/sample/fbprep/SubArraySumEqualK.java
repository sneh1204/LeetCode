package sample.fbprep;

import java.util.HashMap;

public class SubArraySumEqualK {

    public int subarraySum(int[] nums, int k) { // TC - O(N^2) SC - O(1)
        if(nums.length == 1)    return k == nums[0] ? 1 : 0;
        int sum, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k)    ++count;
            }
        }
        return count;
    }

    public int subarraySumHashmap(int[] nums, int k) { // TC - O(N) SC - O(N)
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // sum - sum count
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
