


class Solution109 {
    /**
     * Notes: No need to handle `head == null` corner case.
     *
     * Time:  O(n), every recursive call will generate a node.
     * Space: O(logn), implicit stack, this is a balanced tree.
     */
    public TreeNode sortedListToBST(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return helper(dummy, 0, size - 1);
    }
    
    private TreeNode helper(ListNode dummy, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = helper(dummy, start, mid - 1);
        TreeNode root = new TreeNode(dummy.next.val);
        dummy.next = dummy.next.next;
        root.left = left;
        root.right = helper(dummy, mid + 1, end);
        return root;
    }
    /**
     * Notes: when head is just one list node. `root.left = sortedListToBST(head);` will lead to endless loop.
     *        That's why if `prev == null`, set `head = null`.
     * 
     * Time:  O(n*logn), find middle has extra operation.
     * Space: O(logn), implicit stack, this is a balanced tree.
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = findMidPrev(head);
        ListNode mid = prev == null ? head : prev.next;
        
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }

        ListNode right = mid.next;
        mid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(right);
        return root;
    }
    
    private ListNode findMidPrev(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
}
