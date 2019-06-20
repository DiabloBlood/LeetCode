


class Solution {

    // return value doesn't count as extra space
    // this has a extra O(n) of array fill
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, 1);
        int left = 1;
        for (int i = 0; i < len; i++) {
            result[i] *= left;
            left *= nums[i];
        } 
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    // This solution saved time of extra pas of array fill
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        } 
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    // The trivial O(n^2) solution
    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int product = 1;
            for (int j = 0; j < len; j++) {
                if (j != i) {
                    product *= nums[j]; 
                }
            }
            result[i] = product;
        }
        return result;
    }
}