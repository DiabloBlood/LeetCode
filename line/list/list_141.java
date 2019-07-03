


public class Solution141 {
    /*
     * Proof:
     * Assume: index of circle, 1 <= i <= X, `X` is the circle size.
     *         when slow enter the circle, slow index is `s`, fast index is `f`,
     *         after `k` steps, s == f,
     *         we need to prove that there has the solution of integer k to make (s + k) % X == (s + 2k) % X valid.
     *         => s +  k == a * X + c
     *            f + 2k == b * X + c
     *         => k = (b - a) * X - f + s
     *         => k = t * X - f + s, for arbitray `f` and `s`, integer `k` has infinite solutions.
     * 
     * Complexity: 
     *      list size = H + X, `H` is the part not in the circle.
            when t >= 1, `k` has non-negtive integer solution. Then 1 <= k <= 2*X - 1
     * Time:  O(H + X) = O(n)
     * Space: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}









