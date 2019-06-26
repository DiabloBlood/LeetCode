


class Solution328 {
    /* 
     * Case Analysis:
     * 1. n is odd, even finally at null
     * 2. n is even, even finally at the tail
     * Time:  O(n)
     * Space: O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}