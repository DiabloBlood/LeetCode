


class Solution637 {
    /**
     * BFS method.
     *
     * Key Points:
     *     1. Declaration `double sum = 0;` is enough, JVM will automatically change `0` to `0.0`.
     *     2. int 4 bytes, float 4 bytes, double 8 bytes.
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
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }

    /**
     * DFS Method
     *
     * Base Cases:
     *     1. node == null; ---> return; // just return
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value `result` is a empty array list.
     *
     * Time:  best  O(n + logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *                           DFS traverse takes O(n), for loop takes O(logn), since result size is `logn`.
     *        worst O(2n), for skewed binary tree (Any shape). DFS traverse takes O(n), for loop takes O(n).
     *                     In this case the result list size is `n`.
     *        avg   O(n + logn)
     * Space: best  O(2*logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *                         `counts` list takes O(logn) space, and implicit stack also takes O(logn) space.
     *        worst O(2n), for skewed binary tree (Any shape).
     *                     `counts` list takes O(n) space, and implicit stack also takes O(n) space.
     *        avg   O(2*logn)
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        helper(result, counts, 0, root);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / counts.get(i));
        }
        return result;
    }

    private void helper(List<Double> result, List<Integer> counts, int depth, TreeNode node) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(0.0);
            counts.add(0);
        }
        result.set(depth, result.get(depth) + node.val);
        counts.set(depth, counts.get(depth) + 1);
        helper(result, counts, depth + 1, node.left);
        helper(result, counts, depth + 1, node.right);
    }
}
