


class BinarySearchAsc {
    /**
     * Definition: given an ascending array `nums`, an integer `target`,
     *             find the postion with largest value such that `f(x) < target`.
     *
     * Input:  nums = [1, 2, 3, 4, 5, 6, 7]
     * Output: pos = 3, if target = 5
     *         pos = 6, if target = 100
     *         pos = -1, if target = -100
     *
     * Why initialize pos to `-1`?
     *     1. target > nums[n - 1]; ---> // finally pos is `n - 1`.
     *     2. target < nums[0];     ---> // finally pos cannot be `0`, since it's not such that `f(0) < target`,
     *                                      so pos should be `-1`.
     *
     * Why `left <= right` as while loop condition?
     *     if final `pos` is 5:
     *         round k:     left == 4, right == 5, mid = 4, pos = 4;
     *         round k + 1: left == 5, right == 5, mid = 5, pos = 5;
     *         round k + 2: left == 6, right == 5, while loop break;
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int bs1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }

    /**
     * Definition: given an ascending array `nums`, a integer `target`,
     *             find the postion with largest value such that `f(x) <= target`.
     * Input:  nums = [1, 2, 3, 4, 5, 6, 7]
     * Output: pos = 4, if target = 5
     *         pos = 6, if target = 100
     *         pos = -1, if target = -100
     *
     * Why initialize pos to `-1`?
     *     1. target > nums[n - 1]; ---> // finally pos is `n - 1`.
     *     2. target < nums[0];     ---> // finally pos cannot be `0`, since it's not such that `f(0) <= target`,
     *                                      so pos should be `-1`.
     *
     * Why `left <= right` as while loop condition?
     *     if final `pos` is 5:
     *         round k:     left == 4, right == 5, mid = 4, pos = 4;
     *         round k + 1: left == 5, right == 5, mid = 5, pos = 5;
     *         round k + 2: left == 6, right == 5, while loop break;
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int bs2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }

    /**
     * Definition: given an ascending array `nums`, a integer `target`,
     *             find the postion with smallest value such that `f(x) > target`.
     * Input:  nums = [1, 2, 3, 4, 5, 6, 7]
     * Output: pos = 5, if target = 5
     *         pos = 7, if target = 100
     *         pos = 0, if target = -100
     *
     * Why initialize pos to `nums.length`?
     *     1. target < nums[0];     ---> // finally pos is `0`.
     *     2. target > nums[n - 1]; ---> // finally pos cannot be `n - 1`, since it's not such that `f(n - 1) > target`,
     *                                      so pos should be `n`.
     *
     * Why `left <= right` as while loop condition?
     *     if final `pos` is 5:
     *         round k:     left == 5, right == 6, mid = 5, pos = 5;
     *         round k + 1: left == 5, right == 5, mid = 5, pos = 5;
     *         round k + 2: left == 5, right == 4, while loop break;
     *     notes: round k and round k + 1 found final `pos` two times!
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int bs3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }


    /**
     * Definition: given an ascending array `nums`, a integer `target`,
     *             find the postion with smallest value such that `f(x) >= target`.
     * Input:  nums = [1, 2, 3, 4, 5, 6, 7]
     * Output: pos = 4, if target = 5
     *         pos = 7, if target = 100
     *         pos = 0, if target = -100
     *
     * Why initialize pos to `nums.length`?
     *     1. target < nums[0];     ---> // finally pos is `0`.
     *     2. target > nums[n - 1]; ---> // finally pos cannot be `n - 1`, since it's not such that `f(n - 1) >= target`,
     *                                      so pos should be `n`.
     *
     * Why `left <= right` as while loop condition?
     *     if final `pos` is 5:
     *         round k:     left == 5, right == 6, mid = 5, pos = 5;
     *         round k + 1: left == 5, right == 5, mid = 5, pos = 5;
     *         round k + 2: left == 5, right == 4, while loop break;
     *     notes: round k and round k + 1 found final `pos` two times!
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int bs4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int target = 5;
        int pos = BinarySearchAsc.bs4(nums, target);
        System.out.println(pos);
    }
}
