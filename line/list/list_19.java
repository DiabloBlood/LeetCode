


class Solution19 {
    /**
     * Problem Analysis:
     *     1. Consider input 1->2->3->4->5->6->7->8->9->null, n = 3.
     *     2. Use slow & fast pointers, when `fast` arrive at index `n` (NOTE: list is zero indexed),
     *        which means node `4`, then `slow` start off, assign node `1` to `slow`.
     *     3. When `fast` arrive `null`, `slow` will arrive index `length - n + 1`, which means node `7`.
     *     4. Return `slow` as result;
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null) {
            if (count > n) {
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        slow.next = slow.next.next;
        return slow;
    }
}
