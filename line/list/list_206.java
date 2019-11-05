


/**
 * List Tag:
 *     1. Reverse
 */
class Solution206 {
    /*
     * Iterative method.
     * Time:  O(n)
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

    private ListNode helper(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        return helper(next, head);
    }
}
