


class Solution222 {
    /**
     * Traveral method. An O(n) time trivial method.
     * 
     * Problem Analysis:
     *     1. Please thinking what is complete binary tree.
     *     2. Get tree height first, then count leaf nodes of the last level.
     *     3. Total nodes of complete binary tree is `2^(h - 1) - 1 + last level leaf nodes`.
     *
     * Time:  O(n), get height is `logn`, traverse is `n`.
     * Space: O(logn), traverse recursion stack space is `logn`.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = getHeight(root);
        int[] leafCount = new int[1];
        helper(root, height, leafCount, 1);
        return (1 << (height - 1)) - 1 + leafCount[0];
    }
    
    private int getHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            node = node.left;
            h++;
        }
        return h;
    }
    
    private void helper(TreeNode node, int height, int[] leafCount, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth == height) {
                leafCount[0]++;
            }
            return;
        }
        helper(node.left, height, leafCount, depth + 1);
        helper(node.right, height, leafCount, depth + 1);
    }
}
