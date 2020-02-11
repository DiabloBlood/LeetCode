


class Solution415 {
    /**
     * Notes:
     *     1. The length of both num1 and num2 is < 5100.
     *     2. Both num1 and num2 contains only digits 0-9.
     *     3. Both num1 and num2 does not contain any leading zero.
     *
     * General Cases
     *     1. i <  0 && j <  0 && carry == 0; ---> while loop break;
     *     2. i >= 0 || j >= 0 || carry >  0; ---> while loop continue;
     *
     * Corner Cases:
     *     1. num1 == null || num2 == null; ---> // doesn't need to handle.
     *     2. num1.length() == 0 || num2.length() == 0; // doesn't need to handle.
     *
     * Time:  O(3n), total time is `3 * max(m, n)`, while loop, reverse(), toString() takes `max(m, n)`, respectively.
     * Space: O(n), StringBuilder takes `max(m, n)` space.
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            sum += i >= 0 ? num1.charAt(i--) - '0' : 0;
            sum += j >= 0 ? num2.charAt(j--) - '0' : 0;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
