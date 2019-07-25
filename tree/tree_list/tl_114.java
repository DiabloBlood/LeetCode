


class Solution114 {
    /**
     * Analysis: input [1,2,5,3,4,null,6]
     *      1
     *     / \
     *    2   5
     *   / \   \
     *  3   4   6
     * 
     * 1. Output `1->2->3->4->5->6` is pre-order, `Root-->L-->R`.
     * 2. The output should build as the order of `R-->L-->Root`, which is very like post-order traversal.
     * 3. dummy->null, dummy->6->null, dummy->5->6->null, finally dummy->1->2->3->4->5->6->null.
     * 
     * Time:  O(n), the only way to get result is to traverse all the nodes.
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        helper(dummy, root);
        //node dummy.right is root
    }
    
    private void helper(TreeNode dummy, TreeNode node) {
        if (node == null) {
            return;
        }
        helper(dummy, node.right);
        helper(dummy, node.left);
        node.right = dummy.right;
        node.left = null;
        dummy.right = node;  
    }

    /**
     * Analysis:
     * 1. Build result in pre-order. dummy->null, dummy->1->null, dummy->1->2->null.
     * 
     * Time:  O(n), the only way to get result is to traverse all the nodes.
     * Space: Best  O(1) for flat list tree.
     *        Worst O(logn) for balanced tree.
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tail = new TreeNode(-1);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            tail.right = cur;
            tail.left = null;
            tail = cur;     //tail = tail.right
        }
    }

    /**
     * Analysis:
     * 1. Build result in pre-order. dummy->null, dummy->1->null, dummy->1->2->null.
     * 
     * Time:  O(n), the only way to get result is to traverse all the nodes.
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public void flatten(TreeNode root) {
        TreeNode tail = new TreeNode(-1);
        helper(tail, root);
    }
    
    private TreeNode helper(TreeNode tail, TreeNode node) {
        if (node == null) {
            return tail;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        
        tail.right = node;
        tail.left = null;
        tail = node;    //tail = tail.right
        tail = helper(tail, left);
        tail = helper(tail, right);
        return tail;
    }
}
