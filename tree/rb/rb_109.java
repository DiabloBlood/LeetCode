


class Solution109 {
    /**
     * Notes: when head is just one list node. `root.left = sortedListToBST(head);` will lead to endless loop.
     *        That's why if `prev == null`, set `head = null`.
     * 
     * Time:  O(n*logn), find middle has extra operation.
     * Space: O(logn), implicit stack.
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
