


class Solution21 {
    /*
     * Time: worst O(m + n),
     *       best O(1) if one list is null,
     *       best O(min(m, n)) if the small size list elements totally small than another one.
     * Space: O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next =l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return fakeHead.next;
    }
}