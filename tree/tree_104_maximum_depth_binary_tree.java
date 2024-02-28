


class Solution104 {
    /**
     * Method based on `depth` definition.
     *
     * Key Points:
     *     1. The `depth` of a node is the number of edges from the node to the tree's root node.
     *     2. The `depth` of root node is 1, but the `index` of the root node is 0.
     *     3. The helper functions means return the fatest reached index of this node `cur`.
     *     4. The `null` node have index.
     *     5. The `maxIndex` of this node is max((leftMaxIndex, rightMaxIndex)
     *
     * Base Cases:
     *     1. node == null; ---> return index; which means the depth of parent level is index
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value is `0`.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any Shape).
     *        avg   O(logn)
     */
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int index) {
        if (node == null) {
            return index;
        }

        int leftMaxIndex = helper(node.left, index + 1);
        int rightMaxIndex = helper(node.right, index + 1);
        return Math.max(leftMaxIndex, rightMaxIndex);
    }

    /**
     * Method based on `height` definition.
     *
     * Key Points:
     *     1.The `height` of a node is the number of edges on the longest path from the node to a leaf. A leaf node will have a height of 0.
     *     2. However, this problem `height` of `leaf` is `1`, `height` of `null` is `0`.
     *     3. The `maximum depth` of a binary tree equal to `height` of this binary tree.
     *
     * Base Cases:
     *     1. root == null; ---> return 0; // height of leaf is `1`, `null` of leaf is `0`.
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
