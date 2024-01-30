


class Solution33 {
    /**
     * Problem Pre-Condition:
     *     1. This array is sorted in `ascending` order and rotated at some pivot.
     *     2. No duplicates in this array.
     *
     * Case Analysis:
     *     1. target >  tail && nums[mid] >  tail && nums[mid] <  target; ---> left = mid + 1;
     *     2. target >  tail && nums[mid] >  tail && nums[mid] == target; ---> return mid;
     *     3. target >  tail && nums[mid] >  tail && nums[mid] >  target; ---> right = mid - 1;
     *     4. target >  tail && nums[mid] <= tail;                        ---> right = mid - 1;
     *     5. target <= tail && nums[mid] <= tail && nums[mid] <  target; ---> left = mid + 1;
     *     6. target <= tail && nums[mid] <= tail && nums[mid] == target; ---> retirm mid;
     *     7. target <= tail && nums[mid] <= tail && nums[mid] >  target; ---> right = mid - 1;
     *     8. target <= tail && nums[mid] >  tail;                        ---> left = mid + 1;
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int tail = nums[right];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target >  tail) {
                if (nums[mid] > tail && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] <= tail && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
                       
        }
        return -1;
    }

    /**
     * Problem Pre-Condition:
     *     1. This array is sorted in `ascending` order and rotated at some pivot.
     *     2. No duplicates in this array.
     *
     * Case Analysis:
     *     1. target >  tail && nums[mid] >  tail && nums[mid] <  target; ---> left = mid + 1;
     *     2. target >  tail && nums[mid] >  tail && nums[mid] == target; ---> return mid;
     *     3. target >  tail && nums[mid] >  tail && nums[mid] >  target; ---> right = mid - 1;
     *     4. target >  tail && nums[mid] <= tail;                        ---> right = mid - 1;
     *     5. target <= tail && nums[mid] <= tail && nums[mid] <  target; ---> left = mid + 1;
     *     6. target <= tail && nums[mid] <= tail && nums[mid] == target; ---> retirm mid;
     *     7. target <= tail && nums[mid] <= tail && nums[mid] >  target; ---> right = mid - 1;
     *     8. target <= tail && nums[mid] >  tail;                        ---> left = mid + 1;
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int tail = nums[right];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (target > tail && nums[mid] <= tail) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= tail && nums[mid] > tail) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
                       
        }
        return -1;
    }

    /**
     * Problem Pre-Condition:
     *     1. This array is sorted in `ascending` order and rotated at some pivot.
     *     2. No duplicates in this array.
     * 
     * Problem Analysis:
     *     1. Find min index first, please see solution of leetcode `153`.
     *     2. Then confirm search interval base on `target > tail` and `target <= tail`.
     *
     * Problem Pitfalls:
     *     1. Min index may be `0`, so `minIndex - 1` will out of bound, so use `(minIndex - 1 + n) % n`.
     *
     * Time:  O(2*logn)
     * Space: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int minIndex = findMinIndex(nums);
        int n = nums.length;
        int left = target > nums[n - 1] ? 0 : minIndex;
        int right = target > nums[n - 1] ? (minIndex - 1 + n) % n : n - 1;
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
        return -1;
    }
    
    private int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int tail = nums[right];
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= tail) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    /**
     * Case Analysis:
     *     1. target >  tail && nums[mid] >  tail && nums[mid] <  target; ---> left = mid + 1;
     *     2. target >  tail && nums[mid] >  tail && nums[mid] == target; ---> return mid;
     *     3. target >  tail && nums[mid] >  tail && nums[mid] >  target; ---> right = mid - 1;
     *     4. target >  tail && nums[mid] <= tail;                        ---> right = mid - 1;
     *     5. target <= tail && nums[mid] <= tail && nums[mid] <  target; ---> left = mid + 1;
     *     6. target <= tail && nums[mid] <= tail && nums[mid] == target; ---> retirm mid;
     *     7. target <= tail && nums[mid] <= tail && nums[mid] >  target; ---> right = mid - 1;
     *     8. target <= tail && nums[mid] >  tail;                        ---> left = mid + 1;
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int tail = nums[right];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > tail && nums[mid] > tail && nums[mid] > target
                       || target > tail && nums[mid] <= tail
                       || target <= tail && nums[mid] <= tail && nums[mid] > target) {
                right = mid - 1;     
            } else {
                left = mid + 1;
            }
                       
        }
        return -1;
    }
}
