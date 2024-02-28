


class Solution543 {
    /**
     * Method based on `height` definition.
     *
     * Key Points:
     *     1. For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.
     *     2. For every node, need to return the maxDepth passed this node and the maxDia of this node
     *     3. For every node, the maxDia of this node is the length of longest path which pass it and the maxDia of left subtree and right subtree
     *
     * Base Cases:
     *     1. node == null; ---> Res(-1, -1);
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value is `0`.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
     *        avg   O(logn)
     */
    private class Res {
        int maxDepth;
        int maxDia;
        Res(int maxDepth, int maxDia) {
            this.maxDepth = maxDepth;
            this. maxDia =  maxDia;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Res res = helper(root);
        return res.maxDia;
    }

    private Res helper(TreeNode node) {
        if (node == null) {
            return new Res(0, 0);
        }

        Res leftRes = helper(node.left);
        Res rightRes = helper(node.right);

        int maxDepth = Math.max(leftRes.maxDepth, rightRes.maxDepth) + 1;
        int subMaxDia = Math.max(leftRes.maxDia, rightRes.maxDia);
        int maxDia = Math.max(subMaxDia, leftRes.maxDepth + rightRes.maxDepth);

        return new Res(maxDepth, maxDia);
    }

    /**
     * Use a global max to record the longest path of each node
     *
     * Key Points:
     *     1. For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.
     *     2. The diameter must be one of the longest path that passed a node, so find the global max of the longest path that passed a node, this global max is the diameter
     *
     * Base Cases:
     *     1. node == null; ---> return 0;
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value is `0`.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
     *        avg   O(logn)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        int leftDepth = helper(node.left, res);
        int rightDepth = helper(node.right, res);

        res[0] = Math.max(res[0], leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
