


class Solution83 {
    /**
     * Key Points:
     *     1. This list already been sorted, so duplicates must be consecutive.
     *
     * Problem Analysis:
     *     1. Doesn't need to use dummy node, since `head` must not be removed.
     *     2. `cur.next` as compare pointer, since nodes after `cur` may be removed.
     *     3. `cur` should initilized as `head`.
     *
     * General Cases:
     *     outer while loop:
     *         1. cur.next == null; ---> while loop break;
     *         2. cur.next != null; ---> while loop continue;
     *     inner if else block:
     *         1. cur.next.val == cur.val; ---> cur.next = cur.next.next;
     *            remove `cur.next`, but not move `cur` to next node, since next node may need to be removed again.
     *         2. cur.next.val != cur.val; ---> cur = cur.next;
     * 
     * Corner Cases:
     *     1. head == null; ---> return null; // must be handled, otherwise `cur.next != null` condition will throw `NullPointerException`.
     *
     * Time:  O(n), exactly one pass.
     * Space: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
