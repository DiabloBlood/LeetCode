


class Solution143 {

    /* 
     * Case Analysis:
     * Time:  O(n), findMid O(n/2), reverse (n/2), merge(n /2)
     * Space: O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        merge(head, l2);
    }
    
    private void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next; //l1 = l1.next.next;
            l2 = temp;
        }
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = prev;
            prev = head;
            head = nextHead;
        }
        return prev;
    }
}








