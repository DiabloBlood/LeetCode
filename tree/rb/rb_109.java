


class Solution109 {
    /**
     * Notes:
     *     1. What is height-balanced BST? Sub-tree height diff no more than 1.
     *     2. BST property, left tree < root.val, right tree > root.val. This array is sorted.
     *     3. How about this array has duplicates? Then become left tree <= root.val, right tree >= root.val.
     *     4. The in-order traversal result of a BST is a sorted array.
     *
     * Problem Analysis:
     *     1. Re-build this tree from in-order.
     *     2. Why use `start > end` as base cases? Please see as follow, and the order of `mid` is 0, 1, 2, 3, 4,
     *        which corresponding to `dummy.next = dummy.next.next` after create every root node.
     *        Input: [-10, -3, 0, 5, 9]
     *                                                  (start, end, mid)
     *               ---0---                             --(0, 4, 2)--
     *             /         \                         /               \
     *           -10          5                (0, 1, 0)            (3, 4, 3)
     *          /   \       /   \             /         \          /         \
     *        null  -3    null   9        (0, -1)    (1, 1, 1)  (3, 2)    (4, 4, 4)
     *             /   \       /   \                /         \          /         \
     *           null null   null null           (1, 0)     (2, 1)    (4, 3)     (5, 4)
     *
     *     3. Why every recursive call use `mid` as `root` will build a height-balanced BST?
     *        Use mathmetical induction to prove this theorem, please see as follow, we could know that when `k >= 1`, if array has `2k + 1`
     *        elements, tree structure is `k, root, k`, if array has `2k + 2` elements, tree structure is ` k, root, k + 1`, so the difference
     *        of height of left subtree and right subtree at most is `floor(log(2k+2)) - floor(log(2k+1))`, which is only `0` or `1`.
     *
     *        elements    structure            height    isHeightBal
     *               0    null                      0              Y
     *               1    null, root, null          1              Y
     *               2    null, root, 1             2              Y
     *               3    1, root, 1                2              Y
     *               4    1, root, 2                3              Y
     *               5    2, root, 2                3              Y
     *               6    2, root, 3                3              Y
     *               7    3, root, 3                3              Y
     *               8    3, root, 4                4              Y
     *               9    4, root, 4                4              Y
     *          ......
     *              15    7, root, 7                4              Y
     *              16    7, root, 8                5              Y
     *          ......
     *          2k + 1    k, root, k         1 + log(2k+1)         Y
     *          2k + 2    k, root, k + 1     1 + log(2k+2)         Y
     *
     * Base Cases:
     *     1. start > end; ---> return null;
     *
     * Corner Cases:
     *     1. head == null; ---> // doesn't need to handle, base cases already handled.
     *
     * Time:  O(n), every recursive call will create a node.
     * Space: O(logn), since this BST is a hight-balanced BST, tree height must be `logn`.
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
     * Use an ListNode array which length is `1` as global pointer.
     *
     * Base Cases:
     *     1. start > end; ---> return null;
     *
     * Corner Cases:
     *     1. head == null; ---> // doesn't need to handle, base cases already handled.
     *
     * Time:  O(n), every recursive call will create a node.
     * Space: O(logn), since this BST is a hight-balanced BST, tree height must be `logn`.
     */
    public TreeNode sortedListToBST(ListNode head) {
        ListNode[] cur = new ListNode[] {head};
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return helper(cur, 0, size - 1);
    }

    private TreeNode helper(ListNode[] cur, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = helper(cur, start, mid - 1);
        TreeNode root = new TreeNode(cur[0].val);
        cur[0] = cur[0].next;
        root.left = left;
        root.right = helper(cur, mid + 1, end);
        return root;
    }

    /**
     * Use an global pointer.
     *
     * Base Cases:
     *     1. start > end; ---> return null;
     *
     * Corner Cases:
     *     1. head == null; ---> // doesn't need to handle, base cases already handled.
     *
     * Time:  O(n), every recursive call will create a node.
     * Space: O(logn), since this BST is a hight-balanced BST, tree height must be `logn`.
     */
    private ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return helper(0, size - 1);
    }

    private TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        root.left = left;
        root.right = helper(mid + 1, end);
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
