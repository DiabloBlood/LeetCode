


class Solution111 {
    /**
     * BFS method.
     *
     * Key Points:
     *     1. Find shortest path by using BFS algorithm.
     *
     * Corner Cases:
     *     1. root == null; ---> return 0;
     *        // class `ArrayDeque` instance method `addLast` not allow `null` element (`queue.offer` method will call `ArrayDeuque.addLast` method),
     *           otherwise will throw `NullPointerException` when call `queue.offer` method.
     *
     * Time:  best  O(1), BFS could find minimum depth very early, doesn't need to traverse all nodes.
     *        worst O(n), for skewed binary tree (Any shape), return at the last node.
     *        avg   O(c*n), 0 < c <= 1, for majority input cases, BFS method will get result before traverse all `n` nodes.
     *
     * Space: best  O(1), for skewed binary tree. (Any shape)
     *        worst O(n/2), for full binary tree, complete binary tree is O(4/n) ~ O(n/2),
     *                      height-balanced binary tree is O(n/c), `c` is a number larger than `2`.
     *        avg   O(n/c), `c` is a number larger than `2`, for majority kinds of input trees, nodes number of last several layers at O(n/c) level.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return level;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
        }
        return -1;
    }

    /**
     * DFS (Bottom Up) Method.
     *
     * Key Points:
     *     1. Base on `height` property.
     *
     * Base Cases:
     *     1. root == null; ---> return 0; // case 1: `null` from a leaf node.
     *                                     // case 2: `null` from an one-child parent node.
     * General Cases:
     *     1. lh == 0 && rh == 0; return 1 + lh + rh;
     *     2. lh == 0 && rh >  0; return 1 + lh + rh;
     *     3. lh >  0 && rh == 0; return 1 + lh + rh;
     *     4. lh >  0 && rh >  0; return 1 + Math.min(lh, rh);
     *     case 1, 2, 3 could combine, then general cases become to 2 cases:
     *     1. lh == 0 || rh == 0; return 1 + lh + rh;
     *     2. lh >  0 && rh >  0; return 1 + Math.min(lh, rh);
     *
     * Corner Cases:
     *     1. root == null; ---> return 0; // doesn't need to handle, already handled by base cases.
     *
     * Time:  O(n), binary tree contains `n` nodes, must traverse all `n` nodes to get result.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
     *        avg   O(logn)
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        // or return (lh == 0 || rh == 0) ? 1 + lh + rh : 1 + Math.min(lh, rh);
        return lh > 0 && rh > 0 ? 1 + Math.min(lh, rh) : 1 + lh + rh;
    }

    /**
     * DFS Method
     *
     * Key Points:
     *     1. Base on `depth` property.
     *
     * Base Cases:
     *     1. node == null; ---> return; // `null` from a one-child parent node, not from leaf node.
     *     2. node != null && node.left == null && node.right == null; ---> result[0] = Math.min(result[0], depth); return;
     *        // for this case, node is a leaf, leaf node should calculate minimum depth.
     *
     * General Cases:
     *     1. node != null && (node.left != null || node.right != null); ---> // do nothing, just recursive call left and right.
     *
     * Corner Cases:
     *     1. root == null; ---> return 0; // must be handled, since if not handle, return value is `Integer.MAX_VALUE`.
     *
     * Time:  O(n), binary tree contains `n` nodes, must traverse all `n` nodes to get result.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
     *        avg   O(logn)
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        result[0] = Integer.MAX_VALUE;
        helper(result, 1, root);
        return result[0];
    }

    private void helper(int[] result, int depth, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result[0] = Math.min(result[0], depth);
            return;
        }
        helper(result, depth + 1, node.left);
        helper(result, depth + 1, node.right);
    }

    /**
     * A deprecated method.
     *
     * Case Analysis:
     * 1. left == -1 && right == -1; return depth;
     * 2. left == -1 && right != -1; return right;
     * 3. left 1= -1 && right == -1; return left;
     * 4. left != -1 && right != -1; return min(left, right);
     *
     * Time:  O(n), the only way to get result is to traverse all the nodes
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public int minDepth(TreeNode root) {
        return helper(root, 0) + 1;
    }
    
    private int helper(TreeNode node, int depth) {
        if (node == null) {
            return -1;
        }
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left == -1 && right == -1) {
            return depth;
        }
        return left == -1 ? right : left;
    }
}
