


class Solution148 {
    /*
     * Standard merge sort method.
     *
     * Problem Analysis:
     *     1. Split list into 2 child lists, recursively merge sort each child list, finally merge these 2 child list.
     *     2. Time complexity calculation:
     *         - recursive tree height h = logn
     *         - each level need `n` times merge, `n/2` times find middle, so each level time complexity is O(n)
     *         - finally is O(nlogn)
     *
     * Time:  O(nlogn)
     * Space: O(1)
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(midNext);
        return merge(l1, l2);
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

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    /**
     * Quicksort Method.
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        quicksort(dummy, cur);
        return dummy.next;
    }

    private void quicksort(ListNode headPrev, ListNode tail) {
        if (headPrev == tail || headPrev.next == tail) {
            return;
        }
        ListNode bound = partition(headPrev, tail);
        quicksort(headPrev, bound);
        quicksort(bound, tail);
    }

    private ListNode partition(ListNode headPrev, ListNode tail) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode l1 = dummy1;
        ListNode l2 = dummy2;
        ListNode head = headPrev.next;
        ListNode tailNext = tail.next;
        int val = tail.val;
        while (head != tail.next) {
            if (head.val < val) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }
        l2.next = tailNext;
        l1.next = dummy2.next;
        headPrev.next = dummy1.next;
        return l1;
    }
}
