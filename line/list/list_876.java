


class Solution876 {
    /**
     * Most optimized method.
     *
     * Problem Analysis:
     *     1. List length is odd number, input `1->2->3->4->5->null`, output should be `3->4->5->null`.
     *        Finally ptr `slow` at `3`, ptr `fast` at `5`, `fast.next` is `null`.
     *     2. List length is even number, input `1->2->3->4->5->6->null`, output should be `4->5->6->null`.
     *        Finally ptr `slow` at `4`, ptr `fast` at `null`.
     *
     * Case Analysis:
     *     1. fast == null || fast.next == null; ---> while loop break.
     *     2. fast != null && fast.next != null; ---> while loop continue. (Use demorgan's law)
     *
     * Corner Cases:
     *     1. head == null;      ---> doesn't need to handle, finally return value `slow` is `null`.
     *     2. head.next == null; ---> doesn't need to handle, finally return value `slow` is `head`.
     *
     * Time:  O(n), exactly one pass.
     * Space: O(1)
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Method use `findMid` code template.
     * 
     * Problem Analysis:
     *     1. List length is odd number, input `1->2->3->4->5->null`, output should be `3->4->5->null`.
     *        Finally ptr `slow` at `3`, ptr `fast` at `5`, `fast.next` is `null`.
     *     2. List length is even number, input `1->2->3->4->5->6->null`, output should be `4->5->6->null`.
     *        Finally ptr `slow` at `3`, ptr `fast` at `5`, `fast.next.next` is `null`.
     *
     * Case Analysis:
     *     1. fast.next == null || fast.next.next == null; ---> while loop break.
     *     2. fast.next != null && fast.next.next != null; ---> while loop continue. (Use demorgan's law)
     *
     * Problem Pitfalls:
     *     1. return value is not always `slow` when use `findMid` code template.
     *
     * Corner Cases:
     *     1. head == null;      ---> need to handle, otherwise `fast.next != null` condition will throw `NullPointerException`.
     *     2. head.next == null; ---> doesn't need to handle, return value `slow` is `head`.
     *
     * Time:  O(n), exactly one pass.
     * Space: O(1)
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next == null ? slow : slow.next;
    }
}
