


class Solution129 {
    /**
     * DFS Method
     *
     * Base Cases:
     *     1. node == null; ---> return 0; // `null` can only from an one-child parent node.
     *
     * General Cases:
     *     1. node.left == null && node.right == null; ---> return curNum;
     *     2. node.left != null || node.right != null; ---> // do nothing, not a leaf node, just pass `curNum` to next recrusive calls.
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  O(n), binary tree contains `n` nodes, must traverse all the nodes to get final result.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public int sumNumbers(TreeNode root) {
        return helper(0, root);
    }

    private int helper(int num, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int curNum = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            return curNum;
        }
        return helper(curNum, node.left) + helper(curNum, node.right);
    }

    /**
     * BFS method.
     *
     * Key Points:
     *     1. Use a wrapper class that wrap tree node and path number, then only one queue will be used.
     *
     * General Cases:
     *     1. cur.node.left == null && cur.node.right == null; ---> result += curNum; continue; // continue is a small optimization.
     *     2. cur.node.left != null || cur.node.right != null; ---> // do nothing, not a leaf node, just pass `curNum` to left and right nodes.
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
        int num;
        TreeNode node;
        Node (int _num, TreeNode _node) {
            num = _num;
            node = _node;
        }
    }
    public int sumNumbers(TreeNode root) {
        int result = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, root));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.node == null) {
                continue;
            }
            int curNum = cur.num * 10 + cur.node.val;
            if (cur.node.left == null && cur.node.right == null) {
                result += curNum;
                continue;
            }
            queue.offer(new Node(curNum, cur.node.left));
            queue.offer(new Node(curNum, cur.node.right));
        }
        return result;
    }
}
