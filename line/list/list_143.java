


class Solution143 {

    /* 
     * Problem Analysis:
     *     1. Find the middle node first.
     *     2. Then reverse the second list.
     *     3. Merge l1 and l2.
     *
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

    /**
     * Samples of merge method:
     *     1. Input 1->2->3->4->null, merge l1: 1->2->null and l2: 4->3->null
     *         - l1: 1->4->2->null, l2: 3->null
     *         - l1: 1->4->2->3->null, l2: null
     *         - Finally, l1 at `null`, l2 at `null`
     *     2. Input 1->2->3->4->5->null, merge l1: 1->2->3->null and l2: 5->4->null
     *         - l1: 1->5->2->3->null, l2: 4->null
     *         - l1: 1->5->2->4->3->null, l2: null
     *         - Finally, l1 at `3`, l2 at `null`
     *
     * Case Analysis of merge method:
     *     1. l2 != null, merge
     *     2. l2 == null, merge finished, stop while loop.
     */
    private void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
            l2 = temp;
        }
    }
    
    /**
     * Key Points of findMid method:
     *     1. `head` must not be `null`, otherwise, `fast.next` will throw `NullPointerException`.
     *     2. For 1->2->3->4->null, finally `slow` at `2`.
     *     3. For 1->2->3->4->5->null, finally `slow` at `3`.
     */
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
          ListNode next = head.next;
          head.next = prev;
          prev = head;
          head = next;
        }
        return prev;
    }
}
