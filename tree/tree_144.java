


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
     *        worst O(n), for skewed binary tree.
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
     *        push `right` child first will guarantee `left` child pop first. (Ref stack LIFO order)
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
     * Space: best O(1), for skewed binary tree. (Any kind of skewed binary tree, left skewed, right skewed, or zigzag shape)
     *        worst O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
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
     * Time:  O(n)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree
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
