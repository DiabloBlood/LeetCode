


/**
 * List Tag:
 *     1. Reverse
 */
class Solution206 {
    /*
     * Iterative method.
     *
     * Problem Analysis:
     *     1. Finally, ptr `prev` is the new head, ptr `head` at `null`.
     *
     * Case Analysis:
     *     1. head == null; ---> while loop break.
     *     2. head != null; ---> while loop continue.
     *
     * Corner Cases:
     *     1. head == null; ---> doesn't need to handle, while loop will be skipped and return value `prev` is `null`.
     *
     * Time:  O(n), exactly one pass
     * Space: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head =  next;
        }
        return prev;
    }

    /*
     * Recursive method, not tail recursion.
     * Time:  O(n), `n` nodes called, every node is O(1) times operation.
     * Space: O(n), call stack depth is O(n).
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        // for list 1 -> 2 -> 3 -> 4 -> null, if not assign head.next = null, finaly 1 <-> 2 will have cycle, but other nodes not.
        head.next = null;
        return newHead;
    }

    /*
     * Tail recusion method.
     * Time:  O(n), `n` nodes called, every node is O(1) times operation.
     * Space: O(1) or O(n). If compiler optimized tail recursion, space should be O(1).If not, space is O(n), call stack depth is O(n).
     */
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode prev, ListNode head) {
        if (head == null) {
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        return helper(head, next);
    }
}
