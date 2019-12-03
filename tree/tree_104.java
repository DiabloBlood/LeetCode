


class Solution104 {
    /**
     * Method based on `depth` definition.
     *
     * Key Points:
     *     1. The `depth` of a node is the number of edges from the node to the tree's root node. A root node will have a depth of 0.
     *     2. However, this problem `depth` index start from `1`.
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value `result[0]` is `0`.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
     *        avg   O(logn)
     */
    public int maxDepth(TreeNode root) {
        int[] result = new int[1];
        helper(result, 1, root);
        return result[0];
    }

    private void helper(int[] result, int depth, TreeNode node) {
        if (node == null) {
            return;
        }
        result[0] = Math.max(result[0], depth);
        helper(result, depth + 1, node.left);
        helper(result, depth + 1, node.right);
    }

    /**
     * Method based on `height` definition.
     *
     * Key Points:
     *     1.The `height` of a node is the number of edges on the longest path from the node to a leaf. A leaf node will have a height of 0.
     *     2. However, this problem `height` of `leaf` is `1`, `height` of `null` is `0`.
     *     3. The `maximum depth` of a binary tree equal to `height` of this binary tree.
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value is `0`.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
     *        avg   O(logn)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
