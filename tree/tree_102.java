


class Solution102 {
    /**
     * Recursion Method
     *
     * Base Cases:
     *     1. node == null; ---> return; // just return
     *
     * General Cases:
     *     1. result.size() == depth; ---> result.add(new ArrayList<>());
     *                                     result.get(depth).add(node.val);
     *     2. result.size() >  depth; ---> result.get(depth).add(node.val);
     *     3. result.size() <  depth; ---> // impossible
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value `result` is a empty array list.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape)
     *        avg   O(logn)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, 0, root);
        return result;
    }

    private void helper(List<List<Integer>> result, int depth, TreeNode node) {
        if (node == null) {
            return;
        }
        // or result.size() - 1 < depth
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        helper(result, depth + 1, node.left);
        helper(result, depth + 1, node.right);
    }

    /**
     * BFS method.
     *
     * Key Points:
     *     1. Why use ArrayDeque instead of LinkedList as Queue? Good performance of offer, poll actions.
     *     2. Why use `offer, poll, peek` methods instead of `add, remove, element` methods of Queue interface?
     *        Ref. http://hg.openjdk.java.net/jdk9/jdk9/jdk/file/00cd9dc3c2b5/src/share/classes/java/util/Queue.java
     *     3. Is output space been counted into space complexity?
     *        The standard multi-tape Turing machine definition of space complexity does not count the intput and output.
     *     4. Why queue space is `n/2` when use BFS method traverse a tree?
     *        Assume tree has `n` nodes, height is `h`, last level nodes is `2^h`, total nodes is `2^(h + 1)`.
     *
     * Corner Cases:
     *     1. root == null; ---> return new ArrayList<>();
     *        // `ArrayDeque` class `addLast` method not allow `null` element,
     *           otherwise will throw `NullPointerException` when call `queue.offer` method.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(1), for skewed binary tree. (Any shape)
     *        worst O(n/2), full binary tree, complete binary tree is O(4/n) ~ O(n/2),
     *                      height-balanced binary tree is O(n/c), `c` is a number larger than `2`.
     *        avg   O(n/c), `c` is a number larger than `2`, for majority kinds of input trees, the last several layer nodes at O(n/c) level.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
