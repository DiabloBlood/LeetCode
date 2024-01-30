


public class BinarySearchFindIndex {
    /**
     * Definition: given an ascending array `nums` without duplicates, an integer `target`,
     *             find the postion such that `f(x) == target`.
     *
     * Input:  nums = [1, 2, 3, 4, 5, 6, 7]
     * Output: pos = 4, if target = 5
     *         pos = -1, if target = 100
     *         pos = -1, if target = -100
     *
     * Notes:
     *     1. Ascending array.
     *     2. No duplicates is very important, if have duplicates, not guarantee to find which position.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int bs9(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }

    /**
     * Definition: given a descending array `nums`without duplicates, an integer `target`,
     *             find the postion such that `f(x) == target`.
     *
     * Input:  nums = [7, 6, 5, 4, 3, 2, 1]
     * Output: pos = 2, if target = 5
     *         pos = -1, if target = 100
     *         pos = -1, if target = -100
     *
     * Notes:
     *     1. Descending array.
     *     2. No duplicates is very important, if have duplicates, not guarantee to find which position.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int bs10(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = new int[] {7, 6, 5, 4, 3, 2, 1};
        int target = 5;
        int pos1 = BinarySearchFindIndex.bs9(nums1, target);
        int pos2 = BinarySearchFindIndex.bs10(nums2, target);
        System.out.println(pos1);
        System.out.println(pos2);
    }
}
