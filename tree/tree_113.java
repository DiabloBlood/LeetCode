


class Solution113 {
    /**
     * DFS Method
     *
     * Notes:
     *     1. If `sum` is positive and for all nodes, `node.val` is positive, we could use `if (remain < 0) { return; }` do pruning optimization,
     *        then finally time will less than `n`.
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
     *     1. root == null; ---> doesn't need to handle, base cases already handled this case.
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> paths = new ArrayDeque<>();
        Queue<Integer> sums = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        paths.offer(new ArrayList<>(Arrays.asList(root.val)));
        sums.offer(sum);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            List<Integer> path = paths.poll();
            int remain = sums.poll() - cur.val;
            if (cur.left == null && cur.right == null & remain == 0) {
                result.add(path);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
                sums.offer(remain);
                List<Integer> list = new ArrayList<>(path);
                list.add(cur.left.val);
                paths.offer(list);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                sums.offer(remain);
                List<Integer> list = new ArrayList<>(path);
                list.add(cur.right.val);
                paths.offer(list);
            }
        }
        return result;
    }
}
