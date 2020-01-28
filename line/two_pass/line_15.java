


public class Solution15 {
    /**
     * Problem Pitfalls:
     *     1. Input array is not sorted and has duplicates, sort this array could get result in O(n^2).
     *     2. For input case likes [0, 0, 0, 0, 0], triplet index is (0, 3, 4), others is impossible.
     *     3. For input case likes [-10, -10, 5, 5, 5, 5], triplet index is (0, 2, 5), others is impossible.
     *     4. For three pointers i, j, k, if has duplicates, always use the first appeared index as result.
     *        Otherwise, for input case [0, 0, 0, 0, 0], `i` will finally go to index 3,
     *        for input case [-10, -10, 5, 5, 5, 5], `j` will go to index 5, `k` will go to index 3,
     *        finally will not get any result.
     *
     * Problem Analysis:
     *     1. Use condition `i > 0 && nums[i] == nums[i - 1]` to skip duplicate number at `i` position,
     *        this condition will guarantee always use first appeared duplicate number.
     *     2. Use condition `j < k && nums[j] == nums[j - 1]` to skip duplicate number at `j` position.
     *     3. Use condition `j < k && nums[k] == nums[k + 1]` to skip duplicate number at `k` position.
     *     4. When find a triplet, must finally achive `j++; k--`, otherwise the 2nd while loop will
     *        becomes an endless loop.
     *
     * General Cases:
     *     for loop:
     *         1. a >  0; ---> break; // which means a + b + c > 0, since a < b < c.
     *         2. a <= 0; ---> while loop
     *         while loop (condition check `j < k`):
     *             1. a + b >  0;                   ---> break; // which means it must have a + b + c > 0
     *             2. a + b <= 0 && a + b + c <  0; ---> j++;
     *             3. a + b <= 0 && a + b + c >  0; ---> k--;
     *             4. a + b <= 0 && a + b + c == 0; ---> add triplet; move `j` without dup; move `k` without dup;
     *
     * Corner Cases:
     *     1. nums == null;     ---> return new ArrayList<>();; // otherwise `int n = nums.length` will throw `NullPointerException`.
     *     2. nums.length < 2; ---> // doesn't need to handle, for loop will skip.
     *
     * Time:  O(n^2), sum of sequence `1 + 2 + 3 +...+ n` takes `n^2/2`, sort takes `nlogn`.
     * Space: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // A small optimization
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                // A small optimization
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            } 
        }
        return result;
    }

    /**
     * If you don't want to write `j++; k--` first after find a triplet, try this method
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int a = nums[i];
            // A small optimization
            if (a > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int b = nums[j];
                int c = nums[k];
                // A small optimization
                if (a + b > 0) {
                    break;
                }
                int sum = a + b + c;
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(a, b, c)));
                    while (j < k && nums[j] == b) {
                        j++;
                    }
                    while (j < k && nums[k] == c) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            } 
        }
        return result;
    }
}
