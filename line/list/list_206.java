


class Solution {
    /*
     * Iterative method
     * Time:  O(n)
     * Space: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = prev;
            prev = head;
            head =  nextHead;
        }
        return prev;
    }

    /*
     * Recursive method
     * Time:  O(2n)
     * Space: O(n)
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head;
        return newHead;
    }
}