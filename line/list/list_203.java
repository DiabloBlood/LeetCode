


class Solution203 {
    /**
     * Problem Analysis:
     *     1. Must use dummy node, since `head` may be removed.
     *     2. `cur.next` as compare pointer, since nodes after `cur` may be removed.
     *
     * Case Analysis:
     *     outer while loop:
     *         1. cur.next == null; ---> while loop break;
     *         2. cur.next != null; ---> while loop continue;
     *     inner if else block:
     *         1. cur.next.val == val; ---> cur.next = cur.next.next;
     *            remove `cur.next`, but not move `cur` to next node, since next node may be removed.           
     *         2. cur.next.val == val; ---> cur = cur.next;
     * 
     * Corner Cases:
     *     1. head == null; ---> doesn't need to handle, return value `dummy.next` is `null`.
     *     2. input `1->null`, `val == 1`; ---> return value `dummy.next` is `null`.
     *
     * Time:  O(n), exactly one pass.
     * Space: O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
