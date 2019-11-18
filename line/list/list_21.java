


/**
 * List Tag:
 *     1. Merge
 */
class Solution21 {
    /*
     * Problem Pitfalls:
     *     1. If a list is used out, don't forget another list still has elements. Finally, `cur.next = l1 == null ? l2 : l1`.
     *
     * Case Analysis:
     *     1. l1.val <  l2.val; ---> cur.next = l1; l1 = l1.next;
     *     2. l1.val >= l2.val; ---> cur.next = l2; l2 = l2.next;
     *
     * Time: avg   O(m + n)
     *       worst O(m + n),
     *       best  O(1) if one list is null,
     *       best  O(min(m, n)) if the small size list elements totally small than another one.
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
