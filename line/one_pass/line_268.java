


public class Solution268 {
    /**
     * Problem Analysis:
     *     1. Assume missing number is `x`, then add all [0, n] minus all a[0] -> a[n - 1], the remain number is `x`.
     *
     * Initialization:
     *     1. int sum = nums.length; ---> // since array index only between [0, n - 1]
     *
     * Corner Cases:
     *     1. nums == null; ---> // doesn't need to handle, array guaranteed contains n distince numbers between [0, n].
     *
     * Time:  O(n), one pass for loop.
     * Space: O(1)
     */
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i];
        }
        return sum;
    }

    /**
     * Bit operation method
     *
     * Problem Analysis:
     *     1. XOR operator ^ means, bits same result is 0, bits different result is 1.
     *     2. a ^ b ^ b == a, since b ^ b == 0, a ^ 0 == a.
     *     3. XOR [0, n] and a[0] -> a[n - 1], all the same number pairs will have b ^ b == 0,
     *        assume the mission number is `x`, then finally xor == x.
     *     4. XOR operator comply to commutative law: a ^ b == b ^ a
     *     5. XOR operator comply to associative law: (a ^ b) ^ c == a ^ (b ^ c)
     *
     * Initialization:
     *     1. xor = nums.length; ---> // since array index only between [0, n - 1]
     *
     * Corner Cases:
     *     1. nums == null; ---> // doesn't need to handle, array guaranteed contains n distince numbers between [0, n].
     *
     * Time:  O(n), one pass for loop.
     * Space: O(1)
     */
    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor;
    }

}
