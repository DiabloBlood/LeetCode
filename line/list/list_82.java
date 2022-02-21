


class Solution82 {
    /**
     * Problem Analysis:
     *     1. Consider input `1->3->3->4->null`, output should be `1->4->null`.
     *     2. Dummy node must be used, since it may remove `head` node.
     *     3. `cur.next` as compare pointer, since nodes after `cur` may be removed.
     *
     * General Cases:
     *     outer while loop:
     *         1. cur.next == null; ---> while loop break;
     *         2. cur.next != null; ---> while loop continue;
     *     inner while loop:
     *         init condition: last = cur.next; ---> last is the head of this piece of list (pending processing piece).
     *         1. last.next == null; ---> while loop break, case `cur->1->null`, `cur->1->1->null`, `last` finally at the last `1`.
     *         2. last.next.val != cur.next.val; ---> while loop break, case `cur->1->2->...`, `cur->1->1->2->...`
     *         3. last.next != null && last.next.val == cur.next.val; ---> last = last.next; // while loop continue
     *     inner if else block:
     *         1. last == cur.next; ---> cur = cur.next;
     *            example case `cur->1->null`, `cur->1->2->...`, after while loop break, `last` at `1`,
     *            which means `last` not moved, these piece of list only contains 1 number of `1`, pattern `...->1->...`,
     *            so node `1` doesn't contains duplicates, just remain node `1`
     *         2. last != cur.next; ---> cur.next = last.next;
     *            example case `cur->1->1->null`, `cur->1->1->2->...`, after while loop break, `last` at the second `1` node,
     *            which means `last` moved, these piece of list contains 2 number of `1`s, pattern `...->1->1->...`,
     *            so node `1` contains duplicates, remove node piece `->1->1->`.
     *
     * Corner Cases:
     *     1. head == null; ---> doesn't need to handle, return value `dummy.next` is `null`.
     *     2. 1->1->null; ---> all nodes been removed, finally, `cur` still at `dummy`, return value is `null`.
     *
     * Time:  O(n), exactly one pass, the inner while loop will traverse a piece of list, but ptr `cur` will bypass this piece.
     * Space: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        while (cur.next != null) {
            ListNode last = cur;
            while (last.next != null && cur.next.val == last.next.val) {
                last = last.next;
            }
            if (cur.next != last) {
                cur.next = last.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * Another method use `last` instead of `last.next`
     *
     * Problem Analysis:
     *     1. Consider input `1->3->3->4->null`, output should be `1->4->null`.
     *     2. Dummy node must be used, since it may remove `head` node.
     *     3. `cur.next` as compare pointer, since nodes after `cur` may be removed.
     *
     * Case Analysis:
     *     outer while loop:
     *         1. cur.next == null; ---> while loop break;
     *         2. cur.next != null; ---> while loop continue;
     *     inner while loop:
     *         init condition: last = cur.next; ---> last is the head of this piece of list (pending processing piece).
     *         1. last == null; ---> while loop break, case `cur->1->null`, `cur->1->1->null`, `last` finally at `null`.
     *         2. last.val != cur.next.val; ---> while loop break, case `cur->1->2->...`, `cur->1->1->2->...`, `last` finally at `2`.
     *         3. last != null && last.val == cur.next.val; ---> last = last.next; // while loop continue
     *     inner if else block:
     *         1. last == cur.next.next; ---> cur = cur.next;
     *            example case `cur->1->null`, `cur->1->2->...`, after while loop break, `last` at `null` or `2`,
     *            which means `last` not moved more than 1 nodes, these piece of list only contains 1 number of `1`, pattern `...->1->...`,
     *            so node `1` doesn't contains duplicates, just remain node `1`.
     *         2. last != cur.next.next; ---> cur.next = last;
     *            example case `cur->1->1->null`, `cur->1->1->2->...`, after while loop break, `last` at `null` or `2`,
     *            which means `last` moved more than 1 nodes, these piece of list contains 2 number of `1`s, pattern `...->1->1->...`,
     *            so node `1` contains duplicates, remove node piece `->1->1->`.
     *
     * Corner Cases:
     *     1. head == null; ---> doesn't need to handle, return value `dummy.next` is `null`.
     *     2. 1->1->null; ---> all nodes been removed, finally, `cur` still at `dummy`, return value is `null`.
     *
     * Time:  O(n), exactly one pass, the inner while loop will traverse a piece of list, but ptr `cur` will bypass this piece.
     * Space: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        while (cur.next != null) {
            ListNode last = cur.next;
            while (last != null && last.val == cur.next.val) {
                last = last.next;
            }
            if (last == cur.next.next) {
                cur = cur.next;
            } else {
                cur.next = last;
            }
        }
        return dummy.next;
    }
}
