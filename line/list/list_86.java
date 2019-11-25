


class Solution86 {
    /**
     * Partition function is a subrotine of quicksort.
     *
     * Problem Pitfalls:
     *     1. After loop end, one of `l1.next` and `l2.next` is not null.
     *        Finally assign `l2.next = null`, please refer to Problem Analysis step (3).
     *
     * Problem Analysis:
     *     1. Consider input `1->4->3->2->5->2->null`, `x = 3`, result should be `1->2->2->4->3->5`.
     *     2. Use 2 dummy nodes, left dummy node hold list with nodes less than `x`,
     *        right dummy node hold list with nodes greater or equal than `x`.
     *     3. After partition, list dummy1 is `dummy1->1->2->2->null`, list dummy2 is `dummy2->4->3->5->2->null`,
     *        ptr l1 at `2`, ptr l2 at `5`, we should assign `l2.next = null`.
     *     4. Finally connect two lists, assign `l1.next = dummy2.next`, then return `dummy1.next`.
     *
     * Corner Cases:
     *     1. head == null; ---> doesn't need to handle, the final return value of `dummy1.next` is `null`.
     *
     * Time:  O(n), exactly one pass.
     * Space: O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode l1 = dummy1;
        ListNode l2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }
        l2.next = null;
        l1.next = dummy2.next;
        return dummy1.next;
    }
}
