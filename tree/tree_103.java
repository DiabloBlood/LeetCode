


class Solution103 {
    /**
     * DFS Method
     *
     * Key Points:
     *     1. Use `LinkedList` as inner list, for O(1) time insertion at head.
     *     2. Use `int idx = depth % 2 != 0 ? 0 : list.size();` which inner linked list is reversed order.
     *
     * Base Cases:
     *     1. node == null; ---> return; // just return
     *
     * General Cases:
     *     1. depth == result.size(); ---> result.add(new LinkedList<>());
     *                                     list.add(idx, node.val);
     *     2. depth <  result.size(); ---> list.add(idx, node.val);
     *     3. depth >  result.size(); ---> // impossible
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value `result` is a empty array list.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, 0, root);
        return result;
    }

    private void helper(List<List<Integer>> result, int depth, TreeNode node) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(new LinkedList<>());
        }
        List<Integer> list = result.get(depth);
        int idx = depth % 2 != 0 ? 0 : list.size();
        list.add(idx, node.val);
        helper(result, depth + 1, node.left);
        helper(result, depth + 1, node.right);
    }

    /**
     * BFS method.
     *
     * Key Points:
     *     1. Use `LinkedList` as inner list, for O(1) time insertion at head.
     *     2. Use a boolean flag `odd` to control which inner linked list is reversed order.
     *     3. `list.add(list.size(), cur.val);` is O(1) time.
     *        Ref. http://hg.openjdk.java.net/jdk9/jdk9/jdk/file/9b8c96f96a0f/src/share/classes/java/util/LinkedList.java
     *        (Source Code of add with index method, class LinkedList)
     *                                  \|/
     *        public void add(int index, E element) {
     *            checkPositionIndex(index);
     *
     *            if (index == size)
     *                linkLast(element);
     *            else
     *                linkBefore(element, node(index));
     *        }
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean odd = false;
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int idx = odd ? 0 : list.size();
                list.add(idx, cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(list);
            odd = !odd;
        }
        return result;
    }
}
