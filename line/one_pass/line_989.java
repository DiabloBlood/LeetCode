


class Solution989 {
    /**
     * Notes:
     *     1. 1 <= A.length <= 10000
     *     2. 0 <= A[i] <= 9
     *     3. 0 <= K <= 10000
     *     4. If A.length > 1, then A[0] != 0     
     *
     * General Cases:
     *     1. i <  0 && k == 0 && carry == 0; ---> while loop break;
     *     2. i >= 0 || k >  0 || carry >  0; ---> while loop continue;
     *
     * Time:  O(n), assume A.length is `n`, the operations count of `K` is constant O(1)
     * Space: O(1)
     */
    public List<Integer> addToArrayForm(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        int i = nums.length - 1;
        int carry = 0;
        while (i >= 0 || k > 0 || carry > 0) {
            int sum = carry;
            sum += i >= 0 ? nums[i--] : 0;
            sum += k % 10;
            result.add(0, sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        return result;
    }
}
