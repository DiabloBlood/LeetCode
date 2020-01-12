


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
     *                                      case 2: `null` from a leaf node.
     *
     * General Cases:
     *     1. node.left == null && node.right == null; ---> result.add(path.toString());
     *     2. node.left != null || node.right != null; ---> // internal node, do nothing
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  best  O(2n), for skewed binary tree (Any shape), skewed tree only has one leaf node, the largest path size is `n`,
     *                     DFS takes `n` time, generate path string, `path.toString()` method takes `n` time.
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
     * Notes:
     *     1. result size is O(n) ~ O((n/2)*logn), only count `node.val`, not count `->`.
     *
     * General Cases:
     *     1. cur.node.left == null && cur.node.right == null; ---> result.add(cur.path.toString());
     *     2. cur.node.left != null || cur.node.right != null; ---> // pass, must pass, this case cannot determine final result.
     *
     * Corner Cases:
     *     1. root == null; ---> return new ArrayList<>(); // otherwise `cur.path.append(prefix).append(cur.node.val);` will throw `NullPointerException`.
     *
     * Time:  best  O(2n), for skewed binary tree (Any shape), skewed tree only has one leaf node, the largest path size is `n`,
     *                     BFS takes `n` time, generate path string, `path.toString()` method takes `n` time.
     *        worst O(n*(logn)^2), for full binary tree and complete binary tree, assume height is `h`, then for layer `k` it's need
     *                             `(k/2)*2^k` operations, sum sigma (0, h - 1)((k/2)*2^k) <= (h^2)*(2^h) = n*(logn)^2
     *        avg   O(n*(logn)^2)
     * Space: best  O(n), for skewed binary tree (Any shape), path list takes O(n) space, queue takes O(1) space.
     *        worst O(nlogn), for full binary tree and complete binary tree, queue need to store path list for each node.
     *        avg   O(nlogn)
     */
    private class Node {
        StringBuilder path;
        TreeNode node;
        Node (StringBuilder _path, TreeNode _node) {
            path = _path;
            node = _node;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(new StringBuilder(), root));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            String prefix = cur.node == root ? "" : "->";
            cur.path.append(prefix).append(cur.node.val);
            if (cur.node.left == null && cur.node.right == null) {
                result.add(cur.path.toString());
            }
            boolean used = false;
            if (cur.node.left != null) {
                queue.offer(new Node(cur.path, cur.node.left));
                used = true;
            }
            if (cur.node.right != null) {
                StringBuilder path = used ? new StringBuilder(cur.path) : cur.path;
                queue.offer(new Node(path, cur.node.right));
            }
        }
        return result;
    }

    /**
     * BFS Method (which not re-use cur.path, time complexity is even bad, and not GC friendly)
     *
     * Base Cases:
     *     1. cur.node == null; ---> return false; // `null` from an one-child parent node only.
     *
     * General Cases:
     *     1. cur.node.left == null && cur.node.right == null; ---> result.add(cur.path.toString());
     *     2. cur.node.left != null || cur.node.right != null; ---> // pass, must pass, this case cannot determine final result.
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases.
     *
     * Time:  best  O(n*(logn)^2), for full binary tree and complete binary tree, assume height is `h`, then for layer `k` it's need
     *                             `(k/2)*2^k` operations, sum sigma (0, h - 1)((k/2)*2^k) <= (h^2)*(2^h) = n*(logn)^2
     *        worst O(n^2), for skewed binary tree (Any shape), skewed tree only has one leaf node, for every layer, a new path list been
     *                      created, `1 + 2 +...+ n` <= `n^2`.
     *        avg   O(n*(logn)^2)
     * Space: best  O(n), for skewed binary tree (Any shape), path list takes O(n) space, queue takes O(1) space.
     *        worst O(nlogn), for full binary tree and complete binary tree, queue need to store path list for each node.
     *        avg   O(nlogn)
     */
    private class Node {
        StringBuilder path;
        TreeNode node;
        Node (StringBuilder _path, TreeNode _node) {
            path = _path;
            node = _node;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(new StringBuilder(), root));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.node == null) {
                continue;
            }
            String prefix = cur.node == root ? "" : "->";
            cur.path.append(prefix).append(cur.node.val);
            if (cur.node.left == null && cur.node.right == null) {
                result.add(cur.path.toString());
                continue; // a small optimization, not call `null` from leaf node;
            }
            queue.offer(new Node(new StringBuilder(cur.path), cur.node.left));
            queue.offer(new Node(new StringBuilder(cur.path), cur.node.right));
        }
        return result;
    }
}
