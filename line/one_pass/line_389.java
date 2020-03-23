


public class Solution389 {
    /**
     * Notes:
     *     1. System.out.println('a' + 'b') will show 195. This is Java Widening Primitive Conversion.
     *     2. `(char)sum` is Java Narrowing Primitive Conversion.
     *
     * Problem Analysis:
     *     1. This problem is same as 268 (Missing Number).
     *
     * Initialization:
     *     1. int sum = t.charAt(t.length() - 1); ---> // since string s only less one than string t.
     *
     * Corner Cases:
     *     1. nums == null; ---> // doesn't need to handle, s and t guaranteed not empty.
     *
     * Time:  O(n), one pass for loop.
     * Space: O(1)
     */
    public char findTheDifference(String s, String t) {
        int sum = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            sum += t.charAt(i) - s.charAt(i);
        }
        return (char)sum;
    }

    /**
     * Bit operation method
     *
     * Problem Analysis:
     *     1. This problem is same as 268 (Missing Number).
     *
     * Initialization:
     *     1. xor = t.charAt(t.length() - 1); ---> // since string s only less one than string t.
     *
     * Corner Cases:
     *     1. nums == null; ---> // doesn't need to handle, s and t guaranteed not empty.
     *
     * Time:  O(n), one pass for loop.
     * Space: O(1)
     */
    public char findTheDifference(String s, String t) {
        int xor = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            xor = xor ^ s.charAt(i) ^ t.charAt(i);
        }
        return (char)xor;
    }
}
