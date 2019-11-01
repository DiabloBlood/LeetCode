


public class Solution12 {
    /**
     * Problem Pitfalls:
     *     1. Input number between [1, 3999]. This is the limitation of roman number.
     *
     * Problem Analysis:
     *     1. Build map rules for roman number and arab number.
     *     2. Calculate quotient of `num / arab[i]`;
     *     3. The count of quotient is the count of roman characters that should be appended.
     *     4. Assign remainder of `num / arab[i]` after every single loop.
     *   
     * Time:  O(1), first for loop has `13` times operations, second for loop at most is `3` times operations.
     * Space: O(1), string builder length is not unlimited!
     */
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        String[] roman = new int[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] arab = new int[] {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder sb = new StringBuilder();
        for (int i = roman.length - 1; i >= 0; i--) {
            int count = num / arab[i];
            num %= arab[i];
            for (int j = 0; j < count; j++) {
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
