


class Solution263 {
    /**
     * Notes:
     *     1. Ugly number are positive numbers.
     *     2. `1` is typically treat as ugly numbers.
     *     3. No need to handle `num == 1` case.
     * Case Analysis: while loop stop condition is num == 1;
     *     1. num % 2 == 0; num /= 2;
     *     2. num % 3 == 0; num /= 3;
     *     3. num % 5 == 0; num /= 5;
     *.    4. ohter;        return flase;
     * Time:  O(logn), imagine input `num` = `a^k`, `a` should between `[2, 5]`. 
     * Space: O(1)
     */
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
