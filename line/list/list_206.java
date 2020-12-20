


class Solution206 {
    /**
     * Iterative method.
     *
     * Problem Analysis:
     *     1. Finally, ptr `prev` is the new head, ptr `head` at `null`.
     *
     * General Cases:
     *     1. head == null; ---> while loop break;
     *     2. head != null; ---> while loop continue;
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
            head = next;
        }
        return prev;
    }

    /**
     * Recursive method, the simulation of iterative method, not tail recursion
     *
     * Base Cases:
     *     1. head == null; ---> return prev; // which means recursion go to tail and null. (tail.next is null)
     *
     * Corner Cases:
     *     1. head == null; ---> doesn't need to handle, helper method directly return null.
     *
     * Time:  O(n), `n` nodes called, every node is call is O(1) overhead.
     * Space: O(n), implicit call stack depth is `n`
     */
    public ListNode reverseList(ListNode head) {
        return helper(null, head);
    }

    private ListNode helper(ListNode prev, ListNode head) {
        if (head == null) {
            return prev;
        }
        ListNode newHead = helper(head, head.next);
        head.next = prev;
        return newHead;
    }

    /*
     * Tail recusion method, the simulation of iterative method.
     *
     * Base Cases:
     *     1. head == null; ---> return prev; // which means recursion go to tail and null. (tail.next is null)
     *
     * Corner Cases:
     *     1. head == null; ---> doesn't need to handle, helper method directly return null.
     *
     * Time:  O(n), `n` nodes called, every node is call is O(1) overhead.
     * Space: O(1) or O(n). If compiler optimizes tail recursion, space should be O(1).If not, space is O(n), implicit call stack depth is O(n).
     */
    public ListNode reverseList(ListNode head) {
        return helper(null, head);
    }

    private ListNode helper(ListNode prev, ListNode head) {
        if (head == null) {
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        return helper(head, next);
    }

    /*
     * Recursive method, not tail recursion.
     *
     * Notes:
     *     1. for list 1 -> 2 -> 3 -> 4 -> null, if not assign head.next = null, finaly 1 <-> 2 will have cycle, but other nodes not.
     *
     * Base Cases:
     *     1. head.next == null; ---> return head; // now head is the tail, tail should be the new head.
     *
     * Corner Cases:
     *     1. head == null; ---> return head; // must handle, otherwise `head.next` check will throw 'NullPointerExcepition'.
     *
     * Time:  O(n), `n` nodes called, every node is call is O(1) overhead.
     * Space: O(n), implicit call stack depth is O(n).
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
