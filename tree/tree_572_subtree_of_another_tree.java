


class Solution572 {
    /**
     * Key Points:
     *     1. For every node of `root`, verify if `subRoot` is a same tree of `root`.
     *     2. If `subRoot` is a not same tree of `root`, recursively verify if `subRoot` is a subtree of `root.left` and `root.right`.
     *
     * Base Cases:
     *     1. root == null; ---> return subRoot == null; // `null` is `null`'s subtree, `null` is subtree of any node
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value is `subRoot == null`.
     *
     * Time:  best O(nlogn), binary tree contains `n` nodes, n + 2 * n/2 + 4 * n/4 + ... + n = nlogn,
     *            - for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n^2), for skewed binary tree. (Any shape)
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
     *        avg   O(logn)
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}