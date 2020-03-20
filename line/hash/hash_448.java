


public class Solution448 {
    /**
     * Problem Analysis:
     *     1. For any array of integers where 1 <= a[i] <= n, this array could be used as an array hash map.
     *        A widely definition should be 1 + k <= a[i] <= n + k, as long as array value has linear mapping
     *        relationship with array index.
     *     2. The basic idea is that we iterate through the input array and mark elements as negative using 
     *        nums[abs(nums[i]) - 1] = -nums[abs(nums[i]) - 1]. In this way all the numbers that we have seen
     *        will be marked as negative. In the second iteration, if a value is not marked as negative, it
     *        implies we have never seen that index before, so just add it to the return list.
     *     3. Input             [ 4,  3,  2,  7, 8, 2,  3,  1]
     *        1st for loop ---> [-4, -3, -2, -7, 8, 2, -3, -1]
     *        2nd for loop ---> [8, 2] ---> return index [5, 6]
     *
     * General Cases:
     *     1. nums[i] > 0;  ---> key = nums[i] - 1;  // index i not has been marked as found before.
     *     2. nums[i] < 0;  ---> key = -nums[i] - 1; // index i been marked as found before.
     *     3. nums[i] == 0; ---> // impossible, since 1 <= a[i] <= n.
     *     4. nums[key] > 0;  ---> nums[key] = -nums[key]; // index `key` first found.
     *     5. nums[key] < 0;  ---> nums[key] = nums[key];  // index `key` 2nd, 3rd .... times found.
     *     6. nums[key] == 0; ---> // impossible, since 1 <= a[i] <= n.
     *
     * Corner Cases:
     *     1. nums == null; ---> return new ArrayList<>(); // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip 1st and 2nd for loop finally return an empty array list.
     *
     * Time:  O(2n), two for loops.
     * Space: O(1),  no extra space used, use the input array as in-place map.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] > 0 ? nums[i] - 1 : -nums[i] - 1;
            nums[key] = nums[key] > 0 ? -nums[key] : nums[key];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
