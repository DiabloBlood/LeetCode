


public class Solution61 {
	/**
     * 
     * Problem Analysis:
     *     1. Index encoding, `head` index is `0`, tail index is `size - 1`;
     *     2. ptr `fast` go to `tail` first, then slow go to node with index `size - k - 1`.
     *
     * Corner Cases::
     *     1. head == null;      ---> Must be handled, otherwise `fast.next will throw `NullPointerException`.
     *     2. k % size == 0;     ---> // doesn't need to handle. Finally, ptr `slow` at index `size - 1`, which is `tail`,
     *                                   ptr `fast` also at `tail`, eventually `head` will not change.
     *     2. head.next == null; ---> // doesn't need to handle, only one node, `k % size` always is `0`,
     *                                   however, `k % size == 0` doesn't need to handle, so this case doesn't need to handle.
     *
     * Time:  O(n), at most two passes, ptr `fast` is O(n), ptr `slow` is O(1 ~ n).
     * Space: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int index = 0;
        while (fast.next != null) {
            fast = fast.next;
            index++;
        }
        int size = index + 1;
        k = k % size;
        for (int i = 0; i < size - k - 1; k++) {
            slow = slow.next;
        }
        fast.next = head; // node fast is tail
        head = slow.next;
        slow.next = null;
        return head;
    }

    /**
     * O(nk) method.
     * 
     * Problem Analysis:
     *     1. Move `tail` to `head`, repeat `k` times.
     *     2. Find node before `tail`, need `cur.next.next != null` as find `tail` while loop condition.
     *
     * Corner Cases::
     *     1. head == null; ---> Must be handled, otherwise `cur.next.next` will throw `NullPointerException`.
     *     2. head.next == null; ---> Must be handled, otherwise, `dummy.next` will be changed to `null`.
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
            cur.next.next = dummy.next; // cur.next is tail
            dummy.next = cur.next;
            cur.next = null;
        }
        return dummy.next;
    }
}
