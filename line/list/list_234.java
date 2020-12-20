


class Solution234 {
    /**
     * Problem Analysis:
     *     1. Find the middle node first.
     *     2. Then reverse the second list.
     *     3. compare l1 and l2.
     *
     * Notes:
     *     1. `findMid` method details, why `mid.next = null` details, please refer list_143.java.
     *
     * Corner Cases:
     *     1. head == null; ---> return; // must handle, otherwise `findMid` method will throw 'NullPointerExcepition'.
     *
     * Time:  O(n), findMid O(n/2), reverse O(n/2), compare avg O(n/2)
     * Space: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        return compare(head, l2);
    }

    private boolean compare(ListNode l1, ListNode l2) {
        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    /**
     * One more fancy writing of compare method
     */
    private boolean compare(ListNode l1, ListNode l2) {
        while (l2 != null && l1.val == l2.val) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2 == null;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
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
