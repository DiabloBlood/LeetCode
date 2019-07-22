class Solution235 {
    /**
     * Case Analysis:
     * 1. p.val == r.val && q.val == r.val; //imposible
     * 2. p.val == r.val && q.val > r.val; return root;
     * 3. p.val == r.val && q.val < r.val; return root;
     * 4. p.val > r.val && q.val == r.val; return root;
     * 5. p.val > r.val && q.val > r.val; call right;
     * 6. p.val > r.val && q.val < r.val; return root;
     * 7. p.val < r.val && q.val == r.val; return root;
     * 8. p.val < r.val && q.val > r.val; return root;
     * 9  p.val < r.val && q.val < r.val; call left;
     */
    /**
     * Time: avg O(logn)
     * Space: O(logn)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // suppose root, p, q != null and they are in the same tree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * Time: avg O(logn)
     * Space: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(p.val > r.val && q.val > r.val || p.val < r.val && q.val < r.val) {
            root = (p.val < root.val) ? root.left : root.right;
        }
        return root;
    }

    /**
     * Time: avg O(logn)
     * Space: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while((p.val - root.val) * (q.val - root.val) > 0) {
            root = (p.val < root.val) ? root.left : root.right;
        }
        return root;
    }
}
