


class BinarySearchAsc {

    /**
     * Definition: given an ascending array `nums`, a integer `target`,
     *             find the postion with largest value such that `f(x) < target`.
     * Input:  nums = [1, 2, 3, 4, 5, 6, 7]
     * Output: pos = 3, if target = 5
     *         pos = 6, if target = 100
     *         pos = -1, if target = -100
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
