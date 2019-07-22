class Solution236 {
    /**
     * Back tracking method.
     * 
     * Case Analysis:
     * 1. node == null; return node; // return null is OK too.
     * 2. node == p; return node;
     * 3. node == q; return node;
     * Call left, call right
     * 4. left == null && right != null; return right;
     * 5. left != null && right == null; return left;
     * 6. left == null && right == null; return null; //return left/right is OK too.
     * 7. left != null && right != null; return node;
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        return helper(root, p, q);
    }
    
    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }
        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }

    /**
     * Back tracking method.
     * 
     * The corner case could conclude into general cases.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
