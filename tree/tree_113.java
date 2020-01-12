


class Solution113 {
    /**
     * DFS Method
     *
     * Notes:
     *     1. If `sum` is positive and for all nodes, `node.val` is positive, we could use `if (remain < 0) { return; }` do pruning optimization,
     *        then finally time complexity will less than `n`.
     *
     * Base Cases:
     *     1. node == null; ---> return false; // case 1: `null` from a leaf node.
     *                                         // case 2: `null` from an one-child parent node.
     * General Cases:
     *     1. node.left == null && node.right == null && remain == 0; ---> result.add(new ArrayList<>(path));
     *     2. node.left == null && node.right == null && remain != 0; ---> // pass, return is OK, but combine with other cases for clean code.
     *     3. node.left != null || node.right != null; ---> // pass, must pass, this case cannot determine final result.
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, base cases already handled this case.
     *
     * Time:  O(n), binary tree has `n` nodes, must traverse all nodes to get the final result.
     * Space: best  O(2logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *              implicit stack takes `logn`, path list takes `logn`.
     *        worst O(2n), for skewed binary tree (Any shape), implicit stack takes `n`, path list takes `n`.
     *        avg   O(2logn)
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), root, sum);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> path, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        int remain = sum - node.val;
        if (node.left == null && node.right == null && remain == 0) {
            result.add(new ArrayList<>(path));
        }
        helper(result, path, node.left, remain);
        helper(result, path, node.right, remain);
        path.remove(path.size() - 1);
    }

    /**
     * BFS Method
     *
     * Time:  O(n)
     * Space: O(nlogn)
     */
    private class Node {
        List<Integer> path;
        TreeNode node;
        int sum;
        Node (List<Integer> _path, TreeNode _node, int _sum) {
          path = _path;
          node = _node;
          sum = _sum;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(new ArrayList<>(), root, sum));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.node == null) {
                continue;
            }
            cur.path.add(cur.node.val);
            int remain = cur.sum - cur.node.val;
            if (cur.node.left == null && cur.node.right == null && remain == 0) {
                result.add(cur.path);
            }
            queue.offer(new Node(new ArrayList<>(cur.path), cur.node.left, remain));
            queue.offer(new Node(new ArrayList<>(cur.path), cur.node.right, remain));
        }
        return result;
    }
}
