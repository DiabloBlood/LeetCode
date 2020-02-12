


public class Solution202 {
    /**
     * Problem Analysis:
     *     1. Use a hashset to check cycle.
     *     2. Use private method `getNext` to calculate square sum of all digits of a number.
     *
     * General Cases:
     *     1. set.add(n);  ---> n = getNext(n);
     *     2. !set.add(n); ---> return false; // which means circle detected.
     *
     * Corner Cases:
     *     1. n <  1; ---> return false; // `0` and negative integer are invalid input.
     *     2. n == 1; ---> // doesn't need to handle, will skip while loop and return true.
     *
     * Time:  O(k), assume it takes `k` times to check circle or finally confirm this is happy number.
     * Space: O(k)
     */
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while (n > 1) {
            if (!set.add(n)) {
                return false;
            }
            n = getNext(n);
        }
        return true;
    }

    private int getNext(int n) {
        int sum = 0;
        while(n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

    /**
     * Problem Analysis:
     *     1. Use slow & fast pointer to detect cycle.
     *     2. Use `fast > 1` as while loop condition is a small optimization,
     *        since fast pointer will detect happy number more quick than slow pointer.
     *     3. For input likes `10`, `100`, when while loop break, may have `slow == fast == 1`.
     *        That's why check if fast == 1 when return.
     *
     * Time:  O(k), assume it takes `k` times to check circle or finally confirm this is happy number.
     * Space: O(1)
     */
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        int slow = n;
        int fast = n;
        while (fast > 1) {
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
            if (slow == fast) {
                break;
            }
        }
        return fast == 1 ? true : false;
    }
}
