


public class Solution66 {
    /**
     * Notes:
     *     1. Input array is a a non-empty array of digits, and representing a non-negative integer.
     *     2. Most significant digit is at the head of the list, each element in the array contain a single digit.
     *     3. The integer does not contain any leading zero, except the number 0 itself.
     *
     * Problem Analysis:
     *     1. If not return after for loop, this case can only be all of the digits of input array is 9.
     *        Likes input [9, 9, 9, 9, 9], return should be [1, 0, 0, 0, 0, 0], new array is int[digits.length + 1].
     *
     * General Cases:
     *     1. digits[i] <  9; ---> digits[i]++; return digits;
     *     2. digits[i] == 9; ---> digits[i] = 0;
     *
     * Corner Cases:
     *     1. digits != null && digits.length > 0 is already guaranteed.
     *
     * Time:  O(n), best case is O(1), avg is O(n/2), worst case is O(n), when all elements of this array is `9`.
     * Space: O(1), worst case is O(n), when all elements of this array is `9`.
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
