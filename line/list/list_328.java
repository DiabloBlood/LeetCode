


class Solution328 {
    /**
     * Problem Analysis:
     *     1. List length is odd number, `even` finally at `null`.
     *        Input is `1->2->3->4->5->null`, output should be `1->3->5->2->4->null`.
     *        init state: odd list: `1->2->3->4->5->null`, ptr `odd` at `1`, even list: `2->3->4->5->null`, ptr `even` at `2`.
     *        loop 1 end: odd list: `1->3->4->5->null`, ptr `odd` at `3`, even list: `2->4->5->null`, ptr `even` at `4`.
     *        loop 2 end: odd list: `1->3->5->null`, ptr `odd` at `5`, even list: `2->4->null`, ptr `even` at `null`.
     *        loop 3 end: loop 3 will break, finally assign `odd.next = evenHead`, then return `head`.
     *     2. List length is even number, `even` finally at `tail`.
     *        Input is `1->2->3->4->5->6->null`, output should be `1->3->5->2->4->6->null`.
     *        init state: odd list: `1->2->3->4->5->6->null`, ptr `odd` at `1`, even list: `2->3->4->5->6->null`, ptr `even` at `2`.
     *        loop 1 end: odd list: `1->3->4->5->6->null`, ptr `odd` at `3`,  even list: `2->4->5->6->null`, ptr `even` at `4`.
     *        loop 2 end: odd list: `1->3->5->6->null`, ptr `odd` at `5`,  even list: `2->4->6->null`, ptr `even` at `6`.
     *        loop 3 end: loop 3 will break, finally assign `odd.next = evenHead`, then return `head`.
     *
     * Case Analysis:
     *     1. even == null || even.next == null; ---> while loop break.
     *     2. even != null && even.next != null; ---> while loop continue. (Use demorgan's law)
     *
     * Corner Cases:
     *     1. head == null;      ---> should be handled, otherwise `ListNode even = head.next` will throw `NullPointerException`.
     *     2. head.next == null; ---> doesn't need to handle.
     *
     * Time:  O(n), exactly one pass.
     * Space: O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
