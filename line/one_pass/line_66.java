


public class Solution66 {
    /**
     * Case Analysis:
     *     1. An array with all elements is `9`.
     *     2. A trivial array.
     *
     * Time:  O(n), best is O(1), worst is O(n),  when all elements of this array is `9`.
     * Space: O(1), worst case is O(n), when all elements of this array is `9`.
     */
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            throw new IllegalArgumentException();
        }
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}