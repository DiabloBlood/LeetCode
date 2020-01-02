


class Solution257 {
    /**
     * DFS Method
     *
     * Key Points:
     *     1. Add `node.val` and `prefix` to path stringbuilder when enter a recursive call, remove it when return this recursive call.
     *     2. Use `setLength` method of stringbuilder to remove characters.
     *     3. `setLength` method is O(1) overhead.
     *
     * Base Cases:
     *     1. node == null; ---> return; // case 1: `null` from a one-child parent.
     *                                   // case 2: `null` from a leaf node.
     *
     * General Cases:
     *     1. node.left == null && node.right == null; ---> result.add(path.toString());
     *     2. node.left != null || node.right != null; ---> // internal node, do nothing
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  best  O(2n), for skewed binary tree (Any shape), skewed tree only has one leaf node, the largest path size is `n`,
     *                     DFS takes O(n) time, generate path string takes O(n) time (`path.toString()` method  takes O(n) time).
     *        worst O(n + (n/2)*logn), for full binary tree and complete binary tree, in this case tree has `n/2` leaf nodes,
     *                                 the largest path size is `logn`, DFS takes O(n) time, takes O((n/2)*logn) time.
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

    /**
     * BFS Method (Time Complexity is very bad)
     *
     * Problem Pitfalls:
     *     1. Why use `paths.offer(new StringBuilder(Integer.toString(root.val)));`?
     *        Since constructor `StringBuilder(int capacity)`, if use `root.val` directly, `root.val` will as capacity.
     *
     * Key Points:
     *     1. Need another queue `paths` to track all the path to current node.
     *
     * General Cases:
     *     1. cur.left == null && cur.right == null; ---> result.add(curPath.toString());
     *     2. cur.left != null || cur.right != null; ---> // internal node, do nothing
     *
     * Corner Cases:
     *     1. root == null; ---> return new ArrayList<>();
     *        // class `ArrayDeque` instance method `addLast` not allow `null` element (`queue.offer` method will call `ArrayDeuque.addLast` method),
     *           otherwise will throw `NullPointerException` when call `queue.offer` method.
     *
     * Time:  best  O(2n), for skewed binary tree (Any shape), skewed tree only has one leaf node, the largest path size is `n`,
     *                     BFS takes O(n) time, generate path string takes O(n) time (`path.toString()` method  takes O(n)).
     *        worst O(n*(logn)^2), for full binary tree and complete binary tree, assume height is `h`, then for layer `k` it's need
     *                        `(k/2)*2^k` operations, sum sigma (0, h - 1)((k/2)*2^k) <= (h^2)*(2*h) = n*(logn)^2
     *        avg   O(n*(logn)^2)
     * Space: best  O(n), for skewed binary tree (Any shape), path takes O(n) space, queue takes O(1) space.
     *        worst O(nlogn), for full binary tree and complete binary tree, queue `paths` need to store all path stringbuilder.
     *        avg   O(2logn)
     * Notes: result size is O(n) ~ O((n/2)*logn), only count `node.val`, not count `->`.
     */
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
                boolean used = false;
                int len = curPath.length();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    curPath.append("->").append(cur.left.val);
                    paths.offer(curPath);
                    used = true;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    StringBuilder sb = used ? new StringBuilder(curPath) : curPath;
                    sb.setLength(len);
                    sb.append("->").append(cur.right.val);
                    paths.offer(sb);
                }
            }
        }
        return result;
    }

    /**
     * A bed BFS method, which not re-use `curPath`
     *
     * Time: for skewed binary tree (Any shape), time rise up to O(n^2).
     *       for full binary tree and complete binary tree, operations doubled of previous method.
     *
     * Not GC friendly, and others not change.
     */
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
