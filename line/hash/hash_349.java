


public class Solution349 {
    /**
     * Problem Analysis:
     *     1. If the two input arrays are not been sorted, hashset method is the best method.
     *     2. Use a hashset store all numbers in array num1, and use an intersection hashset find dedup numbers
     *        from array num2 that contains by num1.
     *
     * General Cases:
     *     1. set.contains(num);  ---> intxn.add(num);
     *     2. !set.contains(num); ---> // do nothing
     *
     * Corner Cases:
     *     1. nums1 == null; ---> return new int[0]; // otherwise `for (int num: nums1)` will throw `NullPointerException`.
     *     2. nums2 == null; ---> return new int[0]; // otherwise `for (int num: nums2)` will throw `NullPointerException`.
     *
     * Time:  best  O(m + n), which means intxn set is empty, then 3rd for loop is O(1), assume nums1.length is `m`, nums2.length is `n`.
     *                        e.g. nums1 = [1, 2, 3], nums2 = [4, 5, 6, 7]
     *        worst O(m + n + min(m, n)), which means all numbers in the samllest array are intersection numbers, intxn set size at most
     *                                    is min(m, n). e.g. nums1 = [1, 2, 3], nums2 = [1, 2, 3, 4, 5]
     *        avg   O(m + n)
     * Space: best  O(min(m, n)), if m < n, set.size() is `m` and intxn is empty. e.g. nums1 = [1, 2, 3], nums2 = [4, 5, 6, 7]
     *        worst O(m + n), if m > n, and all of `m` numbers contains no duplicates, and all `n` numbers contains no duplicates and
     *                        every one of these `n` numbers in the `m` numbers. e.g. nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 3]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> intxn = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }
        for (int num: nums2) {
            if (set.contains(num)) {
                intxn.add(num);
            }
        }
        int[] result = new int[intxn.size()];
        int i = 0;
        for (int num: intxn) {
            result[i++] = num;
        }
        return result;
    }

    /**
     * Two pointer method, if nums1 and nums2 already sorted.
     *
     * Problem Analysis:
     *     1. Use a pointer in each array to find the same numbers.
     *     2. Use a hashset to avoid duplicates.
     *
     * General Cases:
     *     1. while loop condition
     *        a. i <  nums1.length && j <  nums2.length; ---> while loop continue;
     *        b. i >= nums1.length || j >= nums2.length; ---> while loop break;
     *             // the not checked tail part in the long array, the intersection numbers must be added to set before.
     *     2. inside while loop
     *        a. nums1[i] == nums2[j]; ---> set.add(nums1[i]); i++; j++;
     *        b. nums1[i] <  nums2[j]; ---> i++;
     *        c. nums1[i] >  nums2[j]; ---> j++;
     *
     * Corner Cases:
     *     1. nums1 == null; ---> return new int[0]; // otherwise `for (int num: nums1)` will throw `NullPointerException`.
     *     2. nums2 == null; ---> return new int[0]; // otherwise `for (int num: nums2)` will throw `NullPointerException`.
     *
     * Time:  O(min(m, n)), while loop takes `min(m, n)`, result build for loop best is O(1), worst is `min(m, n)` 
     * Space: O(1) ~ O(min(m, n))
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (int num: set) {
            result[k++] = num;
        }
        return result;
    }

    /**
     * Binary search method, at least `nums2` must sorted, otherwise cannot binary search in nums2.
     *
     * Problem Analysis:
     *     1. Use a hashset to avoid duplicates.
     *     2. Please refer `BinarySearchFindIndex.bs9` method.
     *
     * Corner Cases:
     *     1. nums1 == null; ---> return new int[0]; // otherwise `for (int num: nums1)` will throw `NullPointerException`.
     *     2. nums2 == null; ---> return new int[0]; // otherwise `for (int num: nums2)` will throw `NullPointerException`.
     *
     * Time:  O(mlogn), for loop is `m` round, binary search takes `logn` per round.
     * Space: O(1) ~ O(min(m, n))
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (bs(nums2, nums1[i])) {
                set.add(nums1[i]);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num: set) {
            result[i++] = num;
        }
        return result;
    }

    private boolean bs(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
