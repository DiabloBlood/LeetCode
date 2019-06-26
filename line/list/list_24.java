


class Solution {
    /* 
     * Case Analysis:
     * 1. n is odd,  finally cur is the last second node.
     * 2. n is even, finally cur is tail.
     * Time:  O(n)
     * Space: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode cur = fakeHead;
        
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
        }
        
        return fakeHead.next;
    }
}