


class Solution112 {
    /**
     * DFS Method
     *
     * Base Cases:
     *     1. root == null; ---> return false; // case 1: `null` from a leaf node.
     *                                         // case 2: `null` from an one-child parent node.
     * General Cases:
     *     1. root.left == null && root.right == null && remain == 0; ---> return true;
     *     2. root.left == null && root.right == null && remain != 0; ---> // pass, return false is OK, but combine with other cases for clean code.
     *     3. root.left != null || root.right != null; ---> // pass, must pass, this case cannot know final result.
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, base cases already handle this case.
     *
     * Time:  best  O(1), could detect final result very early, `||` operator may also short cut another recursive call, branch pruning.
     *        worst O(n), case 1: this tree doesn't has a path sum equal to input `sum`.
     *                    case 2: only the right most path's sum equal to input `sum`.
     *        avg   O(c*n), 0 < c <= 1, avg time should between O(1) ~ O(n).
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int remain = sum - root.val;
        if (root.left == null && root.right == null && remain == 0) {
            return true;
        }
        return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
    }

    /**
     * BFS method.
     *
     * General Cases:
     *     1. cur.left == null && cur.right == null && remain == 0; ---> return true;
     *     2. cur.left == null && cur.right == null && remain != 0; ---> // pass, must pass, this case cannot decide final result.
     *     3. cur.left != null || cur.right != null; ---> // pass, must pass, this case cannot know final result.
     *
     * Corner Cases:
     *     1. root == null; ---> return false;
     *        // class `ArrayDeque` instance method `addLast` not allow `null` element (`queue.offer` method will call `ArrayDeuque.addLast` method),
     *           otherwise will throw `NullPointerException` when call `queue.offer` method.
     *
     * Time:  best  O(1), could detect final result very early.
     *        worst O(n), case 1: this tree doesn't has a path sum equal to input `sum`.
     *                    case 2: only the right most path's sum equal to input `sum` and the right most path is the longest path.
     *        avg   O(c*n), 0 < c <= 1, avg time should between O(1) ~ O(n).
     *                      for majority input cases, BFS method will get result before traverse all `n` nodes.
     * Space: best  O(1), the leaf node at low level layer has a valid path.
     *        worst O(n), for full binary tree, `queue` takes O(n/2) space, `sums` queue takes O(n/2) space.
     *        avg   O(c*n), 0 < c <= 1, avg space should between O(1) ~ O(n).
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> sums = new ArrayDeque<>();
        queue.offer(root);
        sums.offer(sum);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int remain = sums.poll() - cur.val;
                if (cur.left == null && cur.right == null && remain == 0) {
                    return true;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                    sums.offer(remain);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    sums.offer(remain);
                }
            }
        }
        return false;
    }
}
