


class Solution24 {
    /**
     * Problem Analysis:
     *     1. Must use a dummy node for this problem, since `head` node will change position.
     *     2. Input: 1->2->3->4->5->6->null, output 2->1->4->3->6->5->null, finally `cur` at `5`.
     *     3. Input: 1->2->3->4->5->null, output 2->1->4->3->5->null, finally `cur` at `3`.
     *     4. We should guarantee at least have 2 nodes after ptr `cur`.
     *
     * Case Analysis:
     *     1. cur.next == null || cur.next.next == null; ---> while loop break, depends on if list length is odd or even.
     *     2. cur.next != null && cur.next.next != null; ---> while loop continue. (Use demorgan's law)
     *
     * Corner Cases:
     *     1. head == null;      ---> doesn't need to handle, return value `dummy.next` is `null`.
     *     2. head.next == null; ---> doesn't need to handle, if list contains only one node, code will not run into while loop,
     *                                return value `dummy.next` is `head`.
     *
     * Time:  O(n), exactly ont pass, every loop `cur` will jump over two nodes, total steps is `n / 2`
     * Space: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            node1.next = node2.next;
            node2.next = node1;
            cur.next = node2;
            cur = node1; // cur = cur.next.next
        }
        return dummy.next;
    }
}
