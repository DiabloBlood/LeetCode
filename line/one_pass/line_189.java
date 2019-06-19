/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/

public class Solution189 {

    // Stupid and trivial solution
    /*
    * Time complexity: O(nk)
    * Space complexity: O(1)
    */
    public void rotate3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[len - 1];
            for (int j = len - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    //leet code has cases that k large than nums.length
    /*
    * Time complexity: O(n)
    * Space complexity: O(n)
    */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        int len = nums.length;
        // if k is integer multiple of len, the array seems like not shift
        k = k % len;
        if ( k == 0) {
            return;
        }

        int[] arr = Arrays.copyOf(nums, len);
        int end = 0;

        for (int i = len - k; i < len; i++) {
            nums[end++] = arr[i];
        }
        for (int i = 0; i < len - k; i++) {
            nums[end++] = arr[i];
        }
    }

    /*
    * Time complexity: O(n)
    * Space complexity: O(1)
    */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}




