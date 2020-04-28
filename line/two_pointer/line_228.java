


public class Solution228 {
    /**
     * Notes:
     *     1. Sorted integer array.
     *     2. No duplicates.
     *     3. Even though "0->2" is a short string, but use string builder still faster than string operations.
     *
     * Problem Analysis:
     *     1. Diff pointer problem.
     *
     * Initialization:
     *     1. int i = 1; ---> // avoid nums[i - 1] out of bound, at `i` round of for loop, will handle range between [start, i - 1].
     *     2. i <= nums.length; ---> // when `i` out of bound, build integer range string.
     *
     * General Cases:
     *     1. i == nums.length; ---> build string; start = i; // `start = i` is a place holder for case combination.
     *     2. nums[i - 1] + 1 < nums[i]; ---> build string; start = i;
     *     build string:
     *     a. i - 1 == start; ---> sb.append(nums[start]);
     *     b. i - 1 > start;  ---> sb.append(nums[start]); sb.append("->").append(nums[i - 1]);
     *
     * Corner Cases:
     *     1. nums == null; ---> return new ArrayList<>(); // otherwise `i <= nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip for loop and finally return an empty array list.
     *     3. nums.length == 1; ---> // doesn't need to handle, already handled by general cases, if input is [0] will just return ["0"].
     *     4. case [-2147483648, -2147483647, 2147483647]; ---> // don't use `nums[i] - nums[i - 1] > 1` as condition, which leads integer overflow.
     *     5. nums[i - 1] + 1 will alway not lead to integer overflow, since array is sorted and no duplicates.
     *
     * Time:  O(n), for loop takes `n`
     * Space: O(1), no extra space used, array list is result, not count into space complexity.
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i - 1] + 1 < nums[i]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[start]);
                if (i - 1 > start) {
                    sb.append("->").append(nums[i - 1]);
                }
                result.add(sb.toString());
                start = i;
            }
        }
        return result;
    }
}
