


class Solution23 {
    /**
     * Time: O(mnlogn), `m` is the avg length of each list, `n` is the length of lists.
     *       Recursion tree height is logn, every level has m*n times operations.
     * Space: O(logn), tree height.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l1 = mergeHelper(lists, start, mid);
        ListNode l2 = mergeHelper(lists, mid + 1, end);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
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
        return fakeHead.next;
    }
}