


public class Solution217 {
    /**
     * Problem Analysis:
     *     1. Use hash set check duplicates
     *
     * General Cases:
     *     1. set.contains(num);  ---> return true;
     *     2. !set.contains(num); ---> set.add(num);
     *
     * Corner Cases:
     *     1. nums == null;     ---> return false; // otherwise `for (int num: nums)` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip for loop and return false.
     *
     * Time:  O(n), one pass for loop
     * Space: O(n), extra space of hash set, best O(1) and worst O(n).
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * O(nlogn) method
     *
     * General Cases:
     *     1. nums[i] == nums[i - 1];  ---> return true;
     *     2. nums[i] != nums[i - 1];  ---> // do nothing
     *
     * Corner Cases:
     *     1. nums == null;     ---> return false; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip for loop and return false.
     *     3. nums.length == 1; ---> // doesn't need to handle, will skip for loop and return false.
     *
     * Time:  O(nlogn), Arrays.sort is quicksort, avg time is O(nlogn)
     * Space: O(1)
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * O(n^2) method
     *
     * General Cases:
     *     1. nums[i] == nums[j];  ---> return true;
     *     2. nums[i] != nums[j];  ---> // do nothing
     *
     * Corner Cases:
     *     1. nums == null;     ---> return false; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip 1st for loop and return false.
     *     3. nums.length == 1; ---> // doesn't need to handle, will skip 2nd for loop and return false.
     *
     * Time:  O(n^2), 2 layers for loop
     * Space: O(1)
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
