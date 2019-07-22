


class Solution100 {
    /**
     * Case Analysis:
     * 1. p == null && q == null; return true; (Bottom Condition)
     * 2. p == null && q != null; return false;
     * 3. p != null && q == null; return false;
     * 4. p != null && q != null && p.val != q.val; return false;
     * 5. p != null && q != null && p.val == q.val && isSame(left) && isSame(right); return true;
     * 
     * Complexity: assume tree p has `m` nodes, tree q has `n` nodes.
     * Time:  best O(1), worst O(n) (In worst case m == n)
     * Space: best O(1), avg O(logn) of complete binary tree, worst O(n) of flat list tree
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}