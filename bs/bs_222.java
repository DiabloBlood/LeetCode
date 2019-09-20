


class Solution222 {
    /**
     * Binary search method. An O((logn)^2) method.
     *
     * Problem Analysis:
     *     1. Every recursion only calculate one subtree.
     *
     * Time: O((logn)^2), assume tree height is `h`, 1st layer need `2h` opertions, 2nd layer need `4 * (h - 1)` opertions,
     *                    3rd layer need `4 * (h - 2)` opertions, kth layer need `4 * (h - k + 1)` opertions,
     *                    total = 2h + 4(h - 1) + 4(h - 2) + 4(h - 3) +...+ 4
     *                          = 2h + 2h^2
     *                          = O(h^2)
     * Space O(logn), tree height
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getHeight(root.left, true);
        int rh = getHeight(root.right, false);
        // which means this tree is full binary tree
        if (lh == rh) {
            return (1 << lh + 1) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getHeight(TreeNode node, boolean isLeft) {
        int h = 0;
        while (node != null) {
            h++;
            node = isLeft? node.left : node.right;
        }
        return h;
    }
    /**
     * Traversal method. An O(n) time trivial method.
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
        int h = getHeight(root);
        int leavesCount = helper(root, h, 0);
        return  (1 << h - 1) - 1 + leavesCount;
    }

    private int getHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }

    private int helper(TreeNode node, int height, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && depth == height - 1) {
            return 1;
        }
        return helper(node.left, height, depth + 1) + helper(node.right, height, depth + 1);
    }
}
