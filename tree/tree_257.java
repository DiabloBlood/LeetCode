


class Solution107 {
	/**
     * DFS Method
     *
     * Key Points:
     *    1. Add `node.val` to path list when enter a recursive call, remove it when return this recursive call.
     *
     * Base Cases:
     *     1. node == null; ---> return; // `null` from a one-child parent node, not from leaf node. Or `root` is `null`.
     *
     * General Cases:
     *     1. node.left == null && node.right == null; ---> arrive to leaf node, add path string.
     *     2. node.left != null || node.right != null; ---> // internal node, do nothing
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value `result` is a empty array list.
     *
     * Time:  best  O(2n), for skewed binary tree (Any shape), skewed tree only has one leaf node,
     *                     the largest path list size is `n`, DFS takes O(n) time, generate path string takes O(n) time.
     *        worst O(n + (n/2)*logn), for full binary tree and complete binary tree, in this case tree has `n/2` leaf nodes,
     *                                  the largest path list size is `logn`, DFS takes O(n) time, generate path string takes O((n/2)*logn) time.
     *        avg   O(n + (n/c)*logn), `c` is larger than `2`.
     * Space: best  O(2logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *                         Path list takes O(logn) space, implicit stack takes O(logn) space.
     *        worst O(2n), for skewed binary tree (Any shape), Path list takes O(n) space, implicit stack takes O(n) space.
     *        avg   O(2logn), since majority input trees are height-balanced binary trees.
     *
     * Notes: result size is O(n) ~ O((n/2)*logn)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(result, path, root);
        return result;
    }

    private void helper(List<String> result, List<Integer> path, TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            for(int val: path) {
                sb.append(prefix).append(val);
                prefix = "->";
            }
            result.add(sb.toString());
        }
        helper(result, path, node.left);
        helper(result, path, node.right);
        path.remove(path.size() - 1);
    }
}
