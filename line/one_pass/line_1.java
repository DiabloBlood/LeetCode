


public class Solution1 {
    /**
     * Notes:
     *     1. Assume that each input would have exactly one solution.
     *     2. You may not use the same element twice.
     *
     * Problem Analysis:
     *     1. Use a hashmap, array value as map key, array index as map value.
     *
     * General Cases:
     *     1. map.containsKey(target - nums[i]);  ---> return new int[] { map.get(target - nums[i]), i };
     *     2. !map.containsKey(target - nums[i]); ---> map.put(nums[i], i);
     *
     * Corner Cases:
     *     1. nums == null; ---> return new int[] { -1, -1 }; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip for loop and return { -1, -1 }.
     *
     * Time:  O(n), for loop takes `n` time.
     * Space: O(n), hashmap at most takes `n` space.
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[] {-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    /**
     * O(n^2) algorithm
     */
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
