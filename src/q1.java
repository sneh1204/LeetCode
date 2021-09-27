import java.util.HashMap;
import java.util.Map;

/**
 *
 * TWO SUM
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

public class q1 {

    /*
    public int[] search(int[] arr, int target, int sel_key, int next_key){

        if(sel_key != next_key && arr[sel_key] + arr[next_key] == target)
            return new int[] {sel_key, next_key};
        else{
            if(next_key == arr.length-1)
                return search(arr, target, sel_key+1, 0);
            else
                return search(arr, target, sel_key, next_key+1);
        }

    }
     */

    public int[] optimized(int[] arr, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int pairValue = target-arr[i];
            if (hashMap.containsKey(pairValue)) {
                return new int[]{i, hashMap.get(pairValue)};
            }

            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] ref = new q1().optimized(new int[]{3, 3}, 6);

        for (int r: ref){
            System.out.print(r + " ");
        }

    }

}
