


class Solution21 {
    /*
     * Problem Pitfalls:
     *     1. If a list is used out, don't forget another list still has elements. Finally, `cur.next = l1 == null ? l2 : l1`.
     *
     * General Cases:
     *     1. l1.val <= l2.val; ---> cur.next = l1; l1 = l1.next; // same value l1 has higher priority, which make sure stable sorting.
     *     2. l1.val >  l2.val; ---> cur.next = l2; l2 = l2.next;
     *
     * Corner Cases:
     *     1. l1 == null; ---> // doesn't need to handle, finally dummy.next is l2.
     *     2. l2 == null; ---> // doesn't need to handle, finally dummy.next is l1.
     *     3. l1 == null && l2 == null; ---> // doesn't need to handle, finally dummy.next is null.
     *
     * Time: avg   O(m + n)
     *       worst O(m + n),
     *       best  O(1) if one list is null,
     *       best  O(min(m, n)) if the small size list elements totally smaller than the other one.
     * Space: O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
