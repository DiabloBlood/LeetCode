


public class Solution136 {
    /**
     * Bit operation method
     *
     * Problem Analysis:
     *     1. XOR operator ^ means, bits same result is 0, bits different result is 1.
     *     2. a ^ b ^ b == a, since b ^ b == 0, a ^ 0 == a.
     *     3. XOR all elements in array, those numbers appeared twice will become 0, final result is the single one.
     *     4. XOR operator comply to commutative law: a ^ b == b ^ a
     *     5. XOR operator comply to associative law: (a ^ b) ^ c == a ^ (b ^ c)
     *
     * Initialization:
     *     1. result = 0; ---> // since 0 ^ x == x, not change final result.
     *
     * Corner Cases:
     *     1. nums == null; ---> // doesn't need to handle, this is a non-empty array of integers, every element appears twice except for one
     *
     * Time:  O(n), one pass for loop.
     * Space: O(1)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
