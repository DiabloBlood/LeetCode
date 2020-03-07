


public class Solution12 {
    /**
     * Notes:
     *     1. Input number between [1, 3999]. This is the limitation of roman number.
     *
     * Problem Analysis:
     *     1. Use one string array and one integer array build array map, which maps roman digits and arabic digits.
     *        The reason that cannot use one array map is because roman two char digits likes "CM", "CD"...
     *     2. `count` between [0, 3].
     *
     * Corner Cases:
     *     1. num <= 0 || num > 3999; ---> throw new IllegalArgumentException(); // invalid input
     *
     * Time:  O(1), first for loop has `13` times operations, second for loop at most is `3` times operations.
     * Space: O(1), string builder characters only takes O(1) space.
     */
    public String intToRoman(int num) {
        if (num <= 0 || num > 3999) {
            throw new IllegalArgumentException();
        }
        String[] roman = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arab = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < roman.length; i++) {
            int count = num / arab[i];
            num %= arab[i];
            for (int j = 0; j < count; j++) {
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
