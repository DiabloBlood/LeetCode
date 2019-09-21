


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
     * Space O(logn), stack space is tree height.
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
     * Time:  O(n), get height is `logn`, traverse less than `n`.
     * Space: O(logn), traverse recursion stack space is `logn`.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = getHeight(root);
        int[] count = new int[1];
        helper(root, count, h, 0);
        return  (1 << h - 1) - 1 + count[0];
    }

    private int getHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }

    private boolean helper(TreeNode node, int[] count, int height, int depth) {
        if (node == null && depth == height - 1) {
            return true;
        }

        if (node.left == null && node.right == null) {
            if (depth == height - 1) {
                count[0]++;
                return false;
            }
            return true;
        }
        boolean isStop = helper(node.left, count, height, depth + 1);
        if (isStop) {
            return true;
        }
        return helper(node.right, count, height, depth + 1);
    }

    /**
     * Traversal method. An O(n) time trivial method.
     *
     * Problem Analysis:
     *     1. Counting nodes when traversal, bottom up method.
     *
     * Time:  O(n)
     * Space: O(logn), stack space is tree height.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
