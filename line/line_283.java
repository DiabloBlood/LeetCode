


/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/


/*
* 1. 0 -> end - 1 is valid, which means array[0] - array[end - 1] is not 0
* 2. if nums[i] != 0, which means found next valid number
* 3. put end - (nums.length - 1) to 0
*/

public class Solution283 {

    // O(n) worst case is O(2n), when array is all 0s. Best is O(n) Note: this is a non-sorted array;
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[end++] = nums[i];
            }
        }
        while (end < nums.length) {
            nums[end++] = 0;
        }
    }
}