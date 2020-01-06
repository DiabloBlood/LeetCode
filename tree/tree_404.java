


class Solution404 {
    /**
     * DFS Method
     *
     * Base Cases:
     *     1. node == null; ---> return 0; // `null` can only from an one-child parent node.
     *
     * General Cases:
     *     1. node.left == null && node.right == null && isLeft;  ---> return node.val;
     *     2. node.left != null || node.right != null || !isLeft; ---> // do nothing, not a leaf node or not a right leaf node.
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  O(n), binary tree contains `n` nodes, must traverse all the nodes to get final result.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(false, root);
    }
    
    private int helper(boolean isLeft, TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }
        return helper(true, node.left) + helper(false, node.right);
    }

    /**
     * BFS method.
     *
     * Key Points:
     *     1. Use a wrapper class that wrap tree node and path number, then only one queue will be used.
     *
     * General Cases:
     *     1. cur.node.left == null && cur.node.right == null && cur.isLeft;  ---> result += cur.node.val; continue; // continue is a small optimization.
     *     2. cur.node.left != null || cur.node.right != null || !cur.isLeft; ---> // do nothing, not a leaf node or not a right leaf node.
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, code `if (cur.node == null) { continue };` will break while loop,
     *                              then return value `result` is `0`.
     *
     * Time:  O(n), binary tree contains `n` nodes, must traverse all the nodes to get final result.
     * Space: best  O(1), for skewed binary tree (Any shape).
     *        worst O(n/2), for full binary tree, complete binary tree is O(4/n) ~ O(n/2),
     *                      height-balanced binary tree is O(n/c), `c` is a number larger than `2`.
     *        avg   O(n/c), `c` is a number larger than `2`, for majority kinds of input trees, nodes number of last several layers at O(n/c) level.
     */
    private class Node {
        boolean isLeft;
        TreeNode node;
        Node (boolean _isLeft, TreeNode _node) {
            isLeft = _isLeft;
            node = _node;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(false, root));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.node == null) {
                continue;
            }
            if (cur.node.left == null && cur.node.right == null && cur.isLeft) {
                result += cur.node.val;
                continue;
            }
            queue.offer(new Node(true, cur.node.left));
            queue.offer(new Node(false, cur.node.right));
        }
        return result;
    }
}
