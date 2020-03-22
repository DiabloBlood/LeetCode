


public class Solution442 {
    /**
     * Notes:
     *     1. Some elements appear twice and others appear once, no larger than 3 times. If check exactly
     *        how many times > 2, we can only use the 2nd method.
     *
     * Problem Analysis:
     *     1. For any array of integers where 1 <= a[i] <= n, this array could be used as an array hash map.
     *        A widely definition should be 1 + k <= a[i] <= n + k, as long as array value has linear mapping
     *        relationship with array index.
     *     2. The basic idea is that we iterate through the input array and mark elements as negative using 
     *        nums[abs(nums[i]) - 1] = -nums[abs(nums[i]) - 1]. In this way all the numbers that we have seen
     *        first time will be marked as negative. When 2nd time seen this negtive number, add to result list.
     *     3. Input             [ 4, 3, 2,  7, 8, 2,  3,  1]
     *        1st for loop ---> [-4, 3, 2, -7, 8, 2, -3, -1]
     ＊　　　　                   find elements [3, 2] ---> find indexes [1, 2] ---> return [2, 3]
     *     4. This algorithm could detect odd and even times.
     *     5. If input array has some elements appeared `2, 4, 6, 8...` times, all even times elements will be return.
     *     6. If use `nums[key] = -Math.abs(nums[key]);`, mark all elements appeared >= 1 times as negative, then all
     *        elements appeared >= 2 times will be returned.
     *
     * General Cases:
     *     1. nums[i] > 0;  ---> key = nums[i] - 1;  // index i not has been marked as found before.
     *     2. nums[i] < 0;  ---> key = -nums[i] - 1; // index i been marked as found before.
     *     3. nums[i] == 0; ---> // impossible, since 1 <= a[i] <= n.
     *     4. nums[key] < 0;  ---> result.add(key + 1);
     *
     * Corner Cases:
     *     1. nums == null; ---> return new ArrayList<>(); // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip loop and finally return an empty array list.
     *
     * Time:  O(n), only one for loop
     * Space: O(1), no extra space used, we use input array as a in-place map.
     */
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // or `int key = Math.abs(nums[i]) - 1`
            int key = nums[i] > 0 ? nums[i] - 1 : -nums[i] - 1;
            if (nums[key] < 0) {
                result.add(key + 1);
            }
            nums[key] = -nums[key];
        }
        return result;
    }

    /**
     * Notes:
     *     1. This method could check exactly how many times appeared >= 2 of elements by 2 for loops overhead.
     *     2. Used wide definition 1 + cn <= a[i] <= n + cn, where `c` is an integer >= 1, linear mapping
     *        relationship still maintained.
     *     3. Use `+n` encode algorithm may lead to integer overflow.
     *     4. If input is `0 <= a[i] <= n - 1`, we can only use `+n` encoding algorithm, since `0` cannot apply minus sign.
     *     5. Introducing operator `%` and `/` lead to performance loss.
     *
     * Problem Analysis:
     *     1. Input             [ 4,  3,  2,  7, 8, 2,  3, 1]
     *        1st for loop ---> [12, 19, 18, 15, 8, 2, 11, 9]
     *        2nd for loop ---> find elements [19, 18] ---> find indexes [1, 2] ---> return [2, 3]
     *     2. Why use `(nums[i] - 1) % n` instead of `nums[i] % n - 1`? If element `8` been marked as `16`,
     *        if we use `nums[i] % n - 1`, key will be `-1`, if we use `(nums[i] - 1) % n`, key will be `7`,
     *        which corresponding to last index `n - 1`.
     *     3. Use `(nums[i] - 1) / n` could know how many times appreared of element `i + 1`.
     *
     * General Cases:
     *     1. (nums[i] - 1) / n == 2; ---> result.add(i + 1); // find elements that exactly appear 2 times.
     *
     * Corner Cases:
     *     1. nums == null; ---> return new ArrayList<>(); // otherwise `int n = nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip 1st and 2nd for loop and finally return an empty array list.
     *
     * Time:  O(2n), two for loops.
     * Space: O(1),  no extra space used, we use input array as a in-place map.
     */
    public List<Integer> findDuplicates(int[] nums) {
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
            if ((nums[i] - 1) / n == 2) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
