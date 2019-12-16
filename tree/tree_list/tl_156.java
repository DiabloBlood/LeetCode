


class Solution156 {
    /**
     * Question Context:
     *     Given a binary tree where all the right nodes are either leaf nodes with a sibling
     *     (a left node that shares the same parent node) or empty, flip it upside down and turn it into a
     *     tree where the original right nodes turned into left leaf nodes. Return the new root.
     *
     * Key Points:
     *     1. This problem very like list_206.java, reverse linked list.
     *     2. The shape/structure of input tree is very important (All the right nodes are either leaf nodes with a sibling or `null`).
     *     3. height/depth of this input tree between `n/2` (all right nodes are leaf nodes) ~ `n`(all right nodes are `null`)
     *
     * Problem Analysis:
     *     1. Use ptr `prev` and ptr `rightPrev` track previous root node and previous right node.
     *
     * General Cases:
     *     1. root != null; ---> while loop continue;
     *     2. root == null; ---> while loop break;
     *
     * Time:  O(n), tree height/depth between `n/2` ~ `n`,
     *             `n/2` means all right nodes are leaf nodes, `n` means all right nodes are `null`.
     * Space: O(1), no extra space used.
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode rightPrev = null;
        while (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = rightPrev;
            root.right = prev;
            prev = root;
            rightPrev = right;
            root = left;
        }
        return prev;
    }
}
