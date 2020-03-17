


public class Solution31 {
    /**
     * Notes:
     *     1. Please note next permutation is lexicographically next greater permutation.
     *
     * Problem Analysis:
     *     1. From [n - 2, 0], find first index such that `nums[i] < nums[i + 1]`, then break loop, now we found a monotonic
     *        decending (not strict) piece of array with range [idx + 1, n - 1], which must have nums[idx] < nums[idx + 1]
     *        (please note without "=" operator), and range [0, idx] is not guaranteed monotonic.
     *        e.g. 12348752, idx = 3
     *     2. From range [n - 1, idx + 1], find first index such that `nums[i] > nums[idx]`, swap(idx, i), then reverse [idx + 1, n - 1].
     *        e.g. 12348752, swap(idx=3, i=6), ---> 12358742, reverse [4, 7], ---> 12352478
     *
     * General Cases:
     *     1. nums[i] < nums[i + 1]; ---> idx = i; break; // find the potential idx and decending range [idx + 1, n - 1]
     *     2. nums[i] > nums[idx];   ---> swap(nums, idx, i); break; // find first number larger than nums[idx] from range [n - 1, idx + 1].
     *
     * Initialization:
     *     1. idx = -1; ---> // if input is a complete decending array, e.g. 87654321, first for loop will not break and fianlly
     *                          idx is default value -1, it is easily for re-use code `reverse(nums, idx + 1, n - 1);`
     *     2. i = n - 2; ---> // to find decending range [idx + 1, n - 1], avoid out of bound error of code `nums[i] < nums[i + 1]`.
     *     3. i = n - 1; i > idx; ---> // to find first find first number larger than nums[idx] from range [n - 1, idx + 1].
     *
     * Corner Cases:
     *     1. nums == null; ---> return; // otherwise `int n = nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip 2 for loops and skip reverse method.
     *     3. nums.length == 1; ---> // doesn't need to handle, will skip 2 for loops in place reverse this single element.
     *     3. input likes 87654321, a compplete decending array; ---> // refer Initialization.1
     *
     * Time:  best  O(1),    e.g. 12345678, a complete acending array, 1st for loop O(1) break, 2nd for loop O(1) break, O(1) reverse.
     *        worst O(3n),   e.g 78765432, an array idx == 0, range [1, n - 1] is the decending piece, then 1st for loop takes `n`,
     *                       worst case 2nd for loop also takes `n`, reverse takes `n`, total is `3n`
     *        avg   O(1.5n), 1st for loop takes `0.5n`, 2nd for loop takes '0.25n', reverse takes `0.5n`.
     * Space: O(1), inplace reverse, no extra space.
     */
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx > -1) {
            for (int i = n - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    swap(nums, idx, i);
                    break;
                }
            }
        }
        reverse(nums, idx + 1, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
