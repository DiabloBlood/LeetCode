


class Solution92 {
    /**
     * Key Points:
     *     1. Must find node with index `m - 1`, then reverse node.next base on range [m, n].
     *     2. Need a dummy node, otherwise if `m == 1`, we cannot get the previous node of `m`.
     *
     * Problem Analysis:
     *     Asssume input is `1->2->3->4->5->6->7->null`, `m == 3`, `n == 5`.
     *         1. ptr `cur` move to `m - 1 == 2`, `cur.next` is the tail of reversed list, don't lost this node's reference.
     *         2. reverse `3->4->5`, after reverse, ptr `prev` at `5`, which is the new head, ptr `head` at `6`.
     *         3. `2` (`cur`, index `m - 1`) should point to `5`, `3` (`tail`) should point to `6` (`head`, index `n + 1`).
     *
     * Corner Cases:
     *     1. `1 ≤ m ≤ n ≤ length` already guaranteed, otherwise `cur.next` will throw `NullPointerException`.
     *     2. m == 1; ---> if doesn't use dummy node, this case cannot be handled.
     *     3. n == length; ---> finally head is `null`, this case doesn't has any side effect.
     *     4. Only one node case, like `1->null`;
     *        ---> there must have `m == n == 1`, ptr `cur` at `0` and `tail` at `1`, finally `prev` at `1` and `head` at `null`.
     *             this case doesn't has any side effect.
     *
     * Time:  O(n), equal or less than one pass, please note `n <= length`.
     * Space: O(1)
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
        }
        ListNode tail = cur.next; // tail of reversed list.
        ListNode prev = null;
        head = cur.next;
        for (int i = m; i < n + 1; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        cur.next = prev;
        tail.next = head;
        return dummy.next;
    }
}
