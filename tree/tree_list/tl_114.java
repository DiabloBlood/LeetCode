


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
     * Iteration Method (Pre-order, root->L->R)
     *
     * Problem Pitfalls:
     *     1. `head.left = null` is very important.
     *
     * Problem Analysis:
     *     1. Build result from pre-order. `dummy->null`, `dummy->1->null`, `dummy->1->2->null`.
     *     2. `head` start from `dummy`, and always point to `tail` node.
     *
     * Corner Cases:
     *     1. root == null; ---> return;
     *        // `Deque` interface not allow `null` element, otherwise will throw `NullPointerException` when call `stack.push` method.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(1), for skewed binary tree (Any shape). 
     *        worst O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        avg   O(logn)
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode head = new TreeNode(-1);
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
            head.right = cur;
            head.left = null;
            head = head.right;
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
