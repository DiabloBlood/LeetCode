


public class Solution219 {
    /**
     * Problem Analysis:
     *     1. Use a hash map to record the most recent appeared index of a number.
     *     2. Proof of why put most recent index: assume most recent index is x, if i - x > k,
     *        then i - any of all previous indexes > k, too.
     *
     * General Cases:
     *     1. !map.containsKey(nums[i]); ---> map.put(nums[i], i); // record index of this number
     *     2. map.containsKey(nums[i]) && i - map.get(nums[i]) > k;  ---> map.put(nums[i], i);
     *                                    // assume the last appreared index of this number is x, if i - x > k then the
     *                                       distance of i with all previous appeared indexes will large than k for sure.
     *     3. map.containsKey(nums[i]) && i - map.get(nums[i]) <= k; ---> return true; // found one, return directly.
     *
     * Corner Cases:
     *     1. nums == null; ---> return false; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. k < 1; ---> return false; // invalid k
     *     3. nums.length == 0; ---> // doesn't need to handle, will skip for loop and return false.
     *
     * Time:  O(n), one pass for loop
     * Space: O(n), best O(1), worst O(n)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
