


class Solution110 {
    /**
     * Method Tags:
     *     1. Bottom Up.
     *
     * Defination of height-balanced tree:
     *     A binary tree in which the left and right subtrees of `every node` differ in height by no more than 1.
     *
     * Problem Analysis:
     *     1. Depth of a leaf node is `1`, the depth of `null` is `0`.
     *     2. If the corresponding subtree of a node is not balanced, return `-1`
     *
     * Base Cases:
     *     1. node == null; ---> return -0; // `null` is either a leaf node's child or a general node's child.
     *
     * General Cases:
     *     1. leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) >  1; ---> return -1; // which means this subtree is not balance.
     *     2. leftDepth != -1 && rightDepth == -1 && Math.abs(leftDepth - rightDepth) <= 1; Math.max(leftDepth, rightDepth) + 1; 
     *        // Demorgan's law of case 1. which means this subtree is a balanced tree.
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value `helper(root) != -1` will be true.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);

        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * Buttom up method with result wrapper.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree.
     */
    private class MyResult {
        boolean bal;
        int height;
        MyResult(boolean bal, int height) {
            this.bal = bal;
            this.height = height;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return helper(root).bal;
    }
    
    private MyResult helper(TreeNode node) {
        if(node == null) {
            return new MyResult(true, -1);
        }
        MyResult left = helper(node.left);
        MyResult right = helper(node.right);
        boolean bal = left.bal && right.bal && Math.abs(left.height - right.height) <= 1;
        return new MyResult(bal, 1 + Math.max(left.height, right.height));
    }
}
