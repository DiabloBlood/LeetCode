


class Solution23 {
    /**
     * Time: O(n*k*logk), `n` is the avg length of each list, `k` is the length of lists.
     *       Recursion tree height is logn, every level has `n*k` times operations.
     * Space: O(logk), tree height.
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
     * Time:  O(2n*k*logk) first for loop is `k*logk`, second while loop `n*k*logk` poll and `(n*k-k)*logk` offer.
     * Space: O(k), heap size is `k`.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode head: lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
