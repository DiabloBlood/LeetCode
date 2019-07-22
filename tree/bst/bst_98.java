


// case [10, 5, 15, null, null, 6, 20]
class Solution98 {
    /**
     * Time: worst O(n), best O(1)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        if (node.val >= max || node.val <= min) {
            return false;
        }
        
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }


    /**
     * Note: Please use this method, the upper one cannot pass test case [Long.MAX_VALUE]
     * Time: worst O(n), best O(1)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, root.val, root.val, false, false);
    }
    
    private boolean helper(TreeNode node, int min, int max, boolean checkMin, boolean checkMax) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (checkMax && val >= max || checkMin && val <= min) {
            return false;
        }
        return helper(node.left, min, val, checkMin, true) && helper(node.right, val, max, true, checkMax);
    }
}
