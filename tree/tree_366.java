


class Solution366 {
    /**
     * DFS Method (THis is a DFS topological sort)
     *
     * Problem Analysis:
     *     1. Collect all nodes with height `0` first, then with height `1`, ... finally collect node with height `h`.
     *
     * Base Cases:
     *     1. node == null; ---> return; // case 1: `null` from a one-child parent.
     *                                      case 2: `null` from a leaf node.
     *
     * General Cases:
     *     1. height == result.size(); ---> result.add(new ArrayList<>());
     *                                      result.get(height).add(node.val);
     *     2. height <  result.size(); ---> result.get(height).add(node.val);
     *     3. height >  result.size(); ---> // impossible
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  O(n), binary tree contains `n` nodes, must traverse all the nodes to get final result.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private int helper(List<List<Integer>> result, TreeNode node) {
        if (node == null) {
            return -1;
        }
        int height = 1 + Math.max(helper(result, node.left), helper(result, node.right));
        if (height == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(node.val);
        node.left = null;
        node.right = null;
        return height;
    }
}
