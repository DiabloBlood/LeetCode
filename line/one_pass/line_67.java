


class Solution67 {
    /**
     * Notes:
     *     1. The input strings are both non-empty and contains only characters 1 or 0.
     *     2. Similar problems: 2 (Add Two Numbers), 445 (Add Two Numbers II), 989 (Add to Array-Form of Integer),
     *                          415 (Add Strings).
     *
     * General Cases:
     *     1. i <  0 && j <  0 && carry == 0; ---> while loop break;
     *     2. i >= 0 || j >= 0 || carry >  0; ---> while loop continue;
     *
     * Corner Cases:
     *     1. a == null || b == null; ---> return a == null ? b : a; 
     *           // or `String res = a == null ? b : a; return res == null ? "" : res`
     *              if requirement is return "" when a == null && b == null
     *     2. a.length() == 0 || b.length() == 0; ---> // doesn't need to handle, will skip while loop,
     *                                                    return value is another string but has extra overhead
     *                                                    add to StringBuilder, reverse(), toString(), total is O(3n)
     *                                            ---> return a.length() == 0 ? b : a; // for small optimization
     *
     * Time:  O(3n), total time is `3 * max(m, n)`, while loop, reverse(), toString() takes `max(m, n)`, respectively.
     * Space: O(n), StringBuilder takes `max(m, n)` space.
     */
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? a : b;
        }
        if (a.length() == 0 || b.length() == 0) {
            return a.length() == 0 ? b : a;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i--) - '0' : 0;
            sum += j >= 0 ? b.charAt(j--) - '0' : 0;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }

    /**
     * A method with bit operation optimization
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i--) - '0' : 0;
            sum += j >= 0 ? b.charAt(j--) - '0' : 0;
            sb.append(sum & 1);
            carry = sum >> 1;
        }
        return sb.reverse().toString();
    }
}
