


class Solution144 {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        helper(result, node.left);
        helper(result, node.right);
    }

    /**
     * Iteration Method
     *
     * Key Points:
     *     1. Push `cur.right` to stack first, since pre order is `root->left->right`,
     *        push `right` child first will guarantee `left` child pop first. (Ref. stack LIFO order)
     *     2. `Deque` interface not allow `null` element.
     *     3. Why space for height-balanced binary tree, complete binary tree, full binary tree is O(logn)?
     *        Recursion method is hold every `root` nodes in implicit stack,
     *        iteration method is hold every `right` child of `root` nodes in explicit stack, total hold nodes count is same.
     *
     * Corner Cases:
     *     1. root == null; ---> return new ArrayList<>();
     *        // `Deque` interface not allow `null` element, otherwise will throw `NullPointerException` when call `stack.push` method.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(1), for skewed binary tree. (Any shape of skewed binary tree, left skewed, right skewed, or zigzag shape)
     *        worst O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        avg   O(logn)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return result;
    }
}
