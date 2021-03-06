


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
     *        2nd for loop ---> find elements [8, 2] ---> find indexes [4, 5] ---> return [5, 6]
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
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip 1st and 2nd for loop and finally return an empty array list.
     *
     * Time:  O(2n), two for loops.
     * Space: O(1),  no extra space used, we use input array as a in-place map.
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

    /**
     * A more concise method of the first method, but used build-in method `Math.abs`.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int key = Math.abs(nums[i]) - 1;
            nums[key] = -Math.abs(nums[key]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * Notes:
     *     1. Used wide definition 1 + cn <= a[i] <= n + cn, where `c` is an integer >= 1, linear mapping
     *        relationship still maintained.
     *     2. Use `+n` encode algorithm may lead to integer overflow.
     *     3. If input is `0 <= a[i] <= n - 1`, we can only use `+n` encoding algorithm, since `0` cannot apply minus sign.
     *     3. Introducing operator `%` lead to performance loss.
     *
     * Problem Analysis:
     *     1. Input             [ 4,  3,  2,  7, 8, 2,  3, 1]
     *        1st for loop ---> [12, 19, 18, 15, 8, 2, 11, 9]
     *        2nd for loop ---> find elements [8, 2] ---> find indexes [4, 5] ---> return [5, 6]
     *     2. Why use `(nums[i] - 1) % n` instead of `nums[i] % n - 1`? If element `8` been marked as `16`,
     *        if we use `nums[i] % n - 1`, key will be `-1`, if we use `(nums[i] - 1) % n`, key will be `7`,
     *        which corresponding to last index `n - 1`.
     *     3. Use `(nums[i] - 1) / n` could know how many times appreared of element `i + 1`.
     *
     * General Cases:
     *     1. nums[i] <= n; ---> result.add(i + 1); // since 1 <= a[i] <= n, so this case means `nums[i]` not been marked before.
     *
     * Corner Cases:
     *     1. nums == null; ---> return new ArrayList<>(); // otherwise `int n = nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip 1st and 2nd for loop and finally return an empty array list.
     *
     * Time:  O(2n), two for loops.
     * Space: O(1),  no extra space used, we use input array as a in-place map.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int key = (nums[i] - 1) % n;
            nums[key] += n;
        }
        for (int i = 0; i < n; i++) {
            // or condition `(nums[i] - 1) / n == 0`
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
