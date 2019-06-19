


/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
import java.util.HashMap;
import java.util.Map

public class Solution1 {

    // O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target  - nums[i];
            if (map.containsKey(key)) {
                result[0] = map.get(key);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // O (n^2) algorithm 
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null) {
            return result;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}





