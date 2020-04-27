


public class Solution238 {
    /**
     * Notes:
     *     1. It's guaranteed that the product of the elements of any prefix or suffix of the
     *        array (including the whole array) fits in a 32 bit integer.
     *     2. Please solve it without division and in O(n).
     * 
     * Problem Analysis:
     *     1. [2,  3,  4,  5]  ---> // example input,                      
     *     2. [1,  2,  6,  24] ---> // 1st round calculate left products.
     *     3. [60, 40, 30, 24] ---> // 2nd round calculate right products.
     *
     * Initialization:
     *     1. result[0] = 1; ---> // otherwise result[0] == 0 then makes every element to `0`.
     *
     * General Cases:
     *     1. result[i] = result[i - 1] * nums[i - 1];  ---> // calculate left products.
     *     2. right *= nums[i + 1]; result[i] *= right; ---> // calculate right products.
     *
     * Corner Cases:
     *     1. nums == null;     ---> return new int[0]; // otherwise `int n = nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> return new int[0]; // otherwise `result[0] = 1;` will throw `ArrayIndexOutOfBoundsException`.
     *
     * Time:  O(2n), each for loop takes `n`. 
     * Space: O(1), result array doesn't count as extra space.
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            result[i] *= right;
        }
        return result;
    }
}
