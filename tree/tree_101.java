


class Solution101 {
    /**
     * Case Analysis:
     * 1. p == null && q == null; return true; (Bottom Condition)
     * 2. p == null && q != null; return false;
     * 3. p != null && q == null; return false;
     * 4. p != null && q != null && p.val != q.val; return false;
     * 5. p != null && q != null && p.val == q.val && isSymmetric(left) && isSymmetric(right); return true;
     * 
     * Complexity: assume tree p has `m` nodes, tree q has `n` nodes.
     * Time: best O(1), worst O(n) (In worst case m == n)
     * Space: best O(1), avg O(logn) of complete binary tree, worst O(n) of flat list tree
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}