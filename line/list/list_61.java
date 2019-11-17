


public class Solution61 {
	/**
     * index: size - 1, .. size - k, size - k - 1
     * 
     * Problem Analysis:
     *     1. Move `tail` to `head`, repeat `k` times.
     *
     * Corner Cases::
     *     1. head == null; ---> Must be handled, otherwise `cur.next.next` will throw `NullPointerException`.
     *     2. head.next == null; ---> Must be handled, otherwise, `dummy.next` will become to `null`.
     *
     * Time:  O(nk)
     * Space: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        k = k % size;
        if (k == 0) {
            return head;
        }
        ListNode tail = cur;
        cur = head;
        for (int i = 1; i < size - k - 1; i++) {
            cur = cur.next;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
    /**
     * O(nk) method.
     * 
     * Problem Analysis:
     *     1. Move `tail` to `head`, repeat `k` times.
     *
     * Corner Cases::
     *     1. head == null; ---> Must be handled, otherwise `cur.next.next` will throw `NullPointerException`.
     *     2. head.next == null; ---> Must be handled, otherwise, `dummy.next` will become to `null`.
     *
     * Time:  O(nk)
     * Space: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        for (int i = 0; i < k; i++) {
            ListNode cur = dummy;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next.next = dummy.next;
            dummy.next = cur.next;
            cur.next = null;
        }
        return dummy.next;
    }
}
