


class Solution19 {
    /**
     * Problem Analysis:
     *     1. This problem must use dummy node, otherwise if the node intend to remove is head,
     *        we cannot get the previous node of head.
     *     2. Dummy node index is `0`, tail node index is `len - 1`, `null` index is `len`,
     *        when `fast` arrive index `n + 1`, then slow start off,
     *        after `fast` arrive index `len`, which is `null`, `slow` will arrive index `len - n - 1`,
     *        index of the code intended to remove is `len - n`. The relationship is as follow,
     *
     *                               fast        slow
     *        slow start off:        n + 1       0
     *        fast arrive `null`:    len         len - n - 1
     *
     * Corner Cases:
     *     1. `n <= len` is guaranteed, which means `n` is always valid.
     *     2. head == null; ---> this input is impossible, `slow.next.next` will throw `NullPointerException`.
     *     3. head.next == null && n == 1; ---> finally `fast` at `null`, `slow` at index `0`, return value is `null`.
     *
     * Time:  O(n), exactly one pass, ptr `fast` go through this list exactly 1 time.
     * Space: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int index = 0;
        while (fast != null) {
            if (index > n) {
                slow = slow.next;
            }
            fast = fast.next;
            index++;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
