


class Solution257 {
	/**
     * DFS Method
     *
     * Key Points:
     *    1. Add `node.val` and `prefix` to path stringbuilder when enter a recursive call, remove it when return this recursive call.
     *    1. Use `setLength` method of stringbuilder to remove characters.
     *
     * Base Cases:
     *     1. node == null; ---> return; // case 1: `null` from a one-child parent.
     *                                   // case 2: `null` from a leaf node.
     *
     * General Cases:
     *     1. node.left == null && node.right == null; ---> arrive to leaf node, add path string.
     *     2. node.left != null || node.right != null; ---> // internal node, do nothing
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  best  O(2n), for skewed binary tree (Any shape), skewed tree only has one leaf node, the largest path size is `n`,
     *                     DFS takes O(n) time, generate path string takes O(n) time (`path.toString()` method  takes O(n)).
     *        worst O(n + (n/2)*logn), for full binary tree and complete binary tree, in this case tree has `n/2` leaf nodes,
     *                                 the largest path size is `logn`, DFS takes O(n) time, generate path string takes O((n/2)*logn) time.
     *        avg   O(n + (n/c)*logn), `c` is larger than `2`.
     * Space: best  O(2logn), for height-balanced binary tree, complete binary tree, full binary tree,
     *                        path takes O(logn) space, implicit stack takes O(logn) space.
     *        worst O(2n), for skewed binary tree (Any shape), path takes O(n) space, implicit stack takes O(n) space.
     *        avg   O(2logn), since majority input trees are height-balanced binary trees.
     *
     * Notes: result size is O(n) ~ O((n/2)*logn), only count `node.val`, not count `->`.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(result, new StringBuilder(), "", root);
        return result;
    }
    
    private void helper(List<String> result, StringBuilder path, String prefix, TreeNode node) {
        if (node == null) {
            return;
        }
        int len = path.length();
        path.append(prefix).append(node.val);
        if (node.left == null && node.right == null) {
            result.add(path.toString());
        }
        helper(result, path, "->", node.left);
        helper(result, path, "->", node.right);
        path.setLength(len);
    }

    // notes: constructor `StringBuilder(int capacity)`
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<StringBuilder> paths = new ArrayDeque<>();
        queue.offer(root);
        paths.offer(new StringBuilder(Integer.toString(root.val)));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                StringBuilder curPath = paths.poll();
                if (cur.left == null && cur.right == null) {
                    result.add(curPath.toString());
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                    StringBuilder sb = new StringBuilder(curPath);
                    sb.append("->").append(cur.left.val);
                    paths.offer(sb);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    StringBuilder sb = new StringBuilder(curPath);
                    sb.append("->").append(cur.right.val);
                    paths.offer(sb);
                }
            }
        }
        return result;
    }
}
