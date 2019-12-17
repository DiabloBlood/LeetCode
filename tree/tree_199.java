


class Solution199 {
    /**
     * DFS method
     *
     * Problem Analysis:
     *     1. Use `result` list like a path list, but for every position of path list,
     *        only record the first one encountered.
     *     2. Traverse right subtree first, then the rightmost node of every layer will be detected first.
     *     3. Why traverse every node of input tree is necessary? Please see the tree as follow, the rightmost
     *        node may inside the most left subtree, like node `6`, so all node must be traversed.
     *
     *              1          <---
     *             / \
     *            2   3        <---
     *           / \
     *          4   5          <---
     *         /
     *        6                <---
     *
     * Base Cases:
     *     1. node == null; ---> reuturn; // just return.
     *
     * General Cases:
     *     1. depth == result.size(); ---> result.add(node.val);
     *     2. depth <  result.size(); ---> // do nothing, this node is not the rightmost node in this layer.
     *     3. depth >  result.size(); ---> // impossible
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases, return value `result`
     *                              is an empty list.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, 0, root);
        return result;
    }

    private void helper(List<Integer> result, int depth, TreeNode node) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.val);
        }
        helper(result, depth + 1, node.right);
        helper(result, depth + 1, node.left);
    }

    /**
     * BFS method.
     *
     * Problem Analysis:
     *     1. BFS traverse from rightmost node to leftmost node for every layer.
     *     2. Record the first node of every layer.
     *
     * General Cases:
     *     1. i == 0; ---> result.add(cur.val);
     *     2. i >  0; ---> // do nothing
     *
     * Corner Cases:
     *     1. root == null; ---> return new ArrayList<>();
     *        // class `ArrayDeque` instance method `addLast` not allow `null` element (`queue.offer` method will call `ArrayDeuque.addLast` method),
     *           otherwise will throw `NullPointerException` when call `queue.offer` method.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(1), for skewed binary tree (Any shape).
     *        worst O(n/2), for full binary tree, complete binary tree is O(4/n) ~ O(n/2),
     *                      height-balanced binary tree is O(n/c), `c` is a number larger than `2`.
     *        avg   O(n/c), `c` is a number larger than `2`, for majority kinds of input trees, nodes number of last several layers at O(n/c) level.
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    result.add(cur.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return result;
    }
}
