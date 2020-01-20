


class Solution236 {
    /**
     * DFS Method
     * 
     * Problem Pitfalls:
     *     1. If `p` and `q` not in the same tree, this method will mistake `p` or `q` is LCA.
     * 
     * Base Cases:
     *     1. root == null; ---> return root; // case 1: `null` from a leaf node.
     *                                           case 2: `null` from an one-child parent node.
     *     2. root == p;    ---> return root; // case 1: if node `q` inside subtrees of node `p`, then LCA is `p`.
     *                                           case 2: if node `q` not inside subtrees of `p`, then LCA is not `q` or `p`, LCA is another node.
     *                                           note:   it's impossible that `q` is LCA, otherwise `q` is already returned early.
     *     3. root == q;    ---> return root; // case 1: if node `p` inside subtrees of node `q`, then LCA is `q`.
     *                                           case 2: if node `p` not inside subtrees of `q`, then LCA is not `q` or `p`, LCA is another node.
     *                                           note:   it's impossible that `p` is LCA, otherwise `p` is already returned early.
     *     combine case 1, 2, 3:
     *     1. root == null || root == p || root == q; ---> return root;
     *
     * General Cases:
     *     1. left == null && right == null; ---> return right; // which means not find `p` or `q` in this subtree.
     *     2. left == null && right != null; ---> return right; // `p` or `q` in right subtree.
     *     3. left != null && right == null; ---> return left;  // `p` or `q` in left subtree.
     *     4. left != null && right != null; ---> return root;  // root is LCA.
     *     combine case 1, 2, 3, 4:
     *     1. return left == null ? right : right == null ? left : root;
     * 
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases.
     *     2. `p` and `q` are not in the same tree; ---> cannot be detected, will mistake return `p` or `q` as LCA.
     *
     * Time:  best  O(1), could detect result very early, if `root` is `p` or `q`, will directly return the result.
     *        work  O(n), if `p` and `q` are leaves in the last level, all nodes must be traversed to get final result.
     *        avg   O(n), in general cases, time is `c*n`, where `0 < c <=1`
     * Space: best  O(1), if `root` is `p` or `q`, will directly return the result.
     *        worst O(n), for skewed binary tree (Any shape) and `p`, `q` at the last two levels.
     *        avg   O(logn)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        };
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root; 
    }
}
