


public class Solution166 {
    /**
     * Notes:
     *     1. case 30 / 17, return "1.(7647058823529411)"
     *     2. case 19 / 15, return "1.2(6)"
     *     3. case 4 / 3,   return "1.(3)"
     *     4. case 1 / 49,  return "0.(020408163265306122448979591836734693877551)"
     *     5. case 1 / 313, repeating part length is `312`.
     *     6. case 1 / 2147483647, time out.
     *
     * Problem Analysis:
     *     1. Use hashmap to find fractional part cycle.
     *
     * Corner Cases:
     *     1. denominator == 0; ---> throw new IllegalArgumentException(); // otherwise will lead to divide zero error.
     *     2. numerator == 0; ---> // if use `numerator > 0 ^ denominator > 0 ? "-" : ""` will return "-0" of case [0, 3].
     *                                will return before while loop.
     *     3. case 2^-31 / 1; ----> // will lead to integer overflow, so cast int type to long first.
     *     3. case 2 / 1; ---> // should return "2" directly.
     *
     * Time:  O(den / num) level, is num == 1, then at O(den) level, O(den) could seen as the length of repeating part.
     * Space: O(den / num) level, is num == 1, then at O(den) level, O(den) could seen as the length of repeating part.
     */

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        // handle sign
        long num = (long)numerator;
        long den = (long)denominator;
        sb.append(num * den < 0 ? "-" : "");
        num = Math.abs(num);
        den = Math.abs(den);

        // handle integral part
        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return sb.toString();
        }

        // handle fractional part
        Map<Long, Integer> map = new HashMap<>();
        sb.append('.');
        while (num != 0) {
            if (map.containsKey(num)) {
                // `sb.insert(map.get(num), '(');` will throw ambiguous compile error, `sb.insert(map.get(num), "(";` will pass.
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            }
            map.put(num, sb.length());
            num *= 10;
            sb.append(num / den);
            num %= den;
        }
        return sb.toString();
    }
}
