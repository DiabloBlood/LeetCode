


class Solution237 {
    /**
     * Problem Analysis:
     *     1. Consider input `1->2->3->3->4->4->5-null`, result should be `1->2->5`.
     *     2. 
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode last = cur.next;
            while (last.next != null && last.next.val == cur.next.val) {
                last = last.next;
            }
            if (last == cur.next) {
                cur = cur.next;
            } else {
                cur.next = last.next;
            }
        }
        return dummy.next;
    }
}
