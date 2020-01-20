


class Solution235 {
    /**
     * Method by BST basic properties.
     * 
     * Notes:
     *     1. All of the nodes' values will be unique.
     *     2. p and q are different and both values will exist in the BST.
     * 
     * Base Cases:
     *     1. p.val == root.val && q.val <  root.val; ---> return root; // which means p is root.
     *     2. p.val == root.val && q.val >  root.val; ---> return root; // which means p is root.
     *     3. p.val <  root.val && q.val == root.val; ---> return root; // which means q is root.
     *     4. p.val >  root.val && q.val == root.val; ---> return root; // which means q is root.
     *     5. p.val <  root.val && q.val >  root.val; ---> return root;
     *     6. p.val >  root.val && q.val <  root.val; ---> return root;
     *     7. p.val == root.val && q.val == root.val; ---> // impossible, since p and q are different.
     *
     * General Cases:
     *     1. p.val <  root.val && q.val <  root.val; ---> return LCA(root.left, p, q);
     *     2. p.val >  root.val && q.val >  root.val; ---> return LCA(root.right, p, q);
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, since p and q are different and both values
     *                              will exist in the BST guaranteed that this BST is not empty.
     *
     * Time:  best  O(1), could detect result very early, if `root` is `p` or `q`, will directly return the result.
     *        worst O(n), for skewed BST (Any shape), and `p`, `q` at last two levels.
     *        avg   O(logn), for height-balanced BST, complete BST, full BST.
     * Space: best  O(1), if `root` is `p` or `q`, will directly return the result.
     *        worst O(n), for skewed BST (Any shape), and `p`, `q` at last two levels.
     *        avg   O(logn), for height-balanced BST, complete BST, full BST.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }   
}
