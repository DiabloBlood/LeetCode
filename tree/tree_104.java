class Solution104 {
    /**
     * Time:  O(n)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}