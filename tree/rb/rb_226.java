


class Solution226 {
    /**
     * Method Tags:
     *     1. Bottom Up.
     *
     * Problem Analysis:
     *     1. Invert tree could seen as mirror symmetric.
     *     1. Swap `node.left` and `node.right` after left subtree and right subtree already been inverted.
     *     2. Inversion takes place at leaf nodes first, then takes place at upper/root nodes.
     *
     * Base Cases;
     *     1. root == null; ---> return null; // `null` has two kind of cases, from a leaf node or from one-child parent node.
     *
     * Corner Cases:
     *     1. input root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /**
     * A more clear bottom up method.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    /**
     * Method Tags:
     *     1. Top down recursion
     *
     * Base Cases;
     *     1. node == null; ---> return; // `null` has two kind of cases, from a leaf node or from one-child parent node.
     *
     * Corner Cases:
     *     1. input root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape)
     *        avg   O(logn)
     */
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        helper(node.left);
        helper(node.right);
    }

    /**
     * BFS method.
     *
     * Problem Analysis:
     *     1. Use BFS method to swap `cur.left` and `cur.right`.
     *
     * Corner Cases:
     *     1. root == null; ---> return null;
     *        // class `ArrayDeque` instance method `addLast` not allow `null` element (`queue.offer` method will call `ArrayDeuque.addLast` method),
     *           otherwise will throw `NullPointerException` when call `queue.offer` method.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(1), for skewed binary tree (Any shape).
     *        worst O(n/2), for full binary tree, complete binary tree is O(4/n) ~ O(n/2),
     *                      height-balanced binary tree is O(n/c), `c` is a number larger than `2`.
     *        avg   O(n/c), `c` is a number larger than `2`, for majority kinds of input trees, nodes number of last several layers at O(n/c) level.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
