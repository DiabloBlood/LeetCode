


class Solution110 {
    /**
     * Method Tags:
     *     1. Bottom Up.
     *
     * Defination of height-balanced tree:
     *     A binary tree in which the left and right subtrees of `every node` differ in height by no more than 1.
     *
     * Problem Analysis:
     *     1. Height of leaf node is `0`, then `null` should be `-1`.
     *     2. Define `-2` as not valid number, then recursion helper could return `-2` as not valid, other number represents node height.
     *
     * Base Cases:
     *     1. node == null; ---> return -1; // `null` is either a leaf node's child or a general node's child.
     *
     * General Cases:
     *     1. lh == -2 || rh == -2 || Math.abs(lh - rh) >  1; ---> return -2; // which means this subtree is not balance.
     *     2. lh >  -2 && rh >  -2 && Math.abs(lh - rh) <= 1; ---> return 1 + Math.max(lh, rh); 
     *        // Demorgan's law of case 1. which means this subtree is a balanced tree.
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value `helper(root) != -2` will be true.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -2;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int lh = helper(node.left);
        int rh = helper(node.right);
        if (lh == -2 || rh == -2 || Math.abs(lh - rh) > 1) {
            return -2;
        }
        return 1 + Math.max(lh, rh);
    }

    /**
     * Use a final int variable replace -2 and represent the not balance meaning.
     */
    private final int NOT_VALID = -2;

    public boolean isBalanced(TreeNode root) {
        return helper(root) != NOT_VALID;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int lh = helper(node.left);
        int rh = helper(node.right);
        if (lh == NOT_VALID || rh == NOT_VALID || Math.abs(lh - rh) > 1) {
            return NOT_VALID;
        }
        return 1 + Math.max(lh, rh);
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
