


class Solution148 {
    /*
     * Time:  O(1.5 * nlogn), recursive tree has k(logn) levels, every level neen n times merge, n/2 times find middle. 
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
        ListNode l2 = mergeSort(mid.next);
        mid.next = null;
        ListNode l1 = mergeSort(head);
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
}


/*
    // pending quicksort method
    private ListNode partition(ListNode low, ListNode high) {
        int pivot = high.val;
        ListNode dummy = ListNode(-1);
        dummy.next = low;
        ListNode i = dummy;
        ListNode j = dummy;
        while (j.next != high) {
            if (j.next.val < pivot) {
                ListNode temp = i.next;
                ListNode temp2 = j.next.next;
                j.next.next = i.next.next;
                i.next = j.next;
                j.next = temp;
                j.next.next = temp2;
                i = i.next;
            }
            j = j.next;
        }
    }
*/
