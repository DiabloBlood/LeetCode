


class Solution226 {
    /**
     * Method Tags:
     *     1. Bottom Up.
     *
     * Problem Analysis:
     *     1. Swap `node.left` and `node.right` after left subtree and right subtree already been inverted.
     *     2. Inversion takes place at leaf nodes first, then takes place at upper/root nodes.
     *
     * Base Cases;
     *     1. root == null; ---> return null; // `null` has two kind of cases, from leaf node or from non-leaf node.
     *
     * Corner Cases:
     *     1. input root == null; ---> // doesn't need to handle, already been handled by base cases.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
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
     * Method Tags:
     *     1. Top down recursion
     *
     * Problem Analysis:
     *     1. Swap `node.left` and `node.right` before left subtree and right subtree already been inverted.
     *     2. Inversion takes place at upper/root nodes first, then takes place at leaf nodes.
     *
     * Base Cases;
     *     1. node == null; ---> return; // `null` has two kind of cases, from leaf node or from non-leaf node.
     *
     * Corner Cases:
     *     1. input root == null; ---> // doesn't need to handle, already been handled by base cases.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
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
     * Time:  O(n)
     * Space: Best O(1) of flat list tree
     *        Worst O(n) of balanced tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
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
