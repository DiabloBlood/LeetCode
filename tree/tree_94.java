


class Solution94 {
    /**
     * Recursion Method
     *
     * Base Cases:
     *     1. node == null; ---> return; // just return
     *
     * Corner Cases:
     *     1. root == null; ---> doesn't need to handle, return value `result` is a empty array list.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree. (Any shape of skewed binary tree, left skewed, right skewed, or zigzag shape)
     *        avg   O(logn)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        helper(result, node.left);
        result.add(node.val);
        helper(result, node.right);
    }

    /**
     * Iteration Method II
     *
     * General Cases:
     *     1. stack.isEmpty()  && cur != null; ---> // there are to cases applied to this condition.
     *         a. First time enter to while loop, at that time, `cur == root`.
     *         b. After `root` and subtree `root.left` been traversed, at that time, `cur == root.right`.
     *     2. !stack.isEmpty() && cur != null; ---> // Very trivial case, when `cur` is one of majority of internal nodes.
     *     3. !stack.isEmpty() && cur == null; ---> // When `cur` is `right` of some nodes, and this `right` is `null`.
     *     4. stack.isEmpty()  && cur == null; ---> // while loop break, all nodes been traversed.
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, return value `result` is an empty array list.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(1), for right skewed binary tree.
     *        worst O(n), for left skewed binary tree. (L->R->L->R->L->R zigzag skewed tree is O(n/2), `n/2` nodes poped and `n/2` nodes inside stack)
     *        avg   O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
