


class BinarySearchDesc {

    /**
     * Definition: given a descending array `nums`, an integer `target`,
     *             find the position with largest value such that `f(x) < target`.
     * Input:  nums = [7, 6, 5, 4, 3, 2, 1]
     * Output: pos = 4, if target = 4
     *         pos = 0, if target = 100
     *         pos = 7, if target = -100
     */
    public static int bs5(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    /**
     * Definition: given a descending array `nums`, an integer `target`,
     *             find the position with largest value such that `f(x) <= target`.
     * Input:  nums = [7, 6, 5, 4, 3, 2, 1]
     * Output: pos = 3, if target = 4
     *         pos = 0, if target = 100
     *         pos = 7, if target = -100
     */
    public static int bs6(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    /**
     * Definition: given a descending array `nums`, an integer `target`,
     *             find the position with smallest value such that `f(x) > target`.
     * Input:  nums = [7, 6, 5, 4, 3, 2, 1]
     * Output: pos = 2, if target = 4
     *         pos = -1, if target = 100
     *         pos = 6, if target = -100
     */
    public static int bs7(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }

    /**
     * Definition: given a descending array `nums`, an integer `target`,
     *             find the position with smallest value such that `f(x) >= target`.
     * Input:  nums = [7, 6, 5, 4, 3, 2, 1]
     * Output: pos = 3, if target = 4
     *         pos = -1, if target = 100
     *         pos = 6, if target = -100
     */
    public static int bs8(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 6, 5, 4, 3, 2, 1};
        int target = -100;
        int pos = BinarySearchDesc.bs8(nums, target);
        System.out.println(pos);
    }
}
