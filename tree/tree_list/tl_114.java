


class Solution114 {
    /**
     * Pre-order traversal method
     *
     * Problem Analysis:
     *     1. If doesn't have code `node.left = null`, final result will not be a right skewed tree, please see below
     *            1               1                 1
     *           / \             / \              /   \
     *          2   5    --->    `->2    --->    2     2
     *         / \   \             / \          / \   / \
     *        3   4   6            `->3        3   3 3   3
     *                                 \        \   \ \   \
     *                                  4        4   4 4   4
     *                                   \        \   \ \   \
     *                                    5        5   5 5   5
     *                                     \        \   \ \   \
     *                                      6        6   6 6   6
     *     2. Build tree from `R-->L-->Root`, very likes post-order, dummy->null, dummy->6->null,
     *        dummy->5->6->null,, ..., dummy->1->2->3->4->5->6->null, which means insert at head.
     *     3. `dummy` will not lead to memory leak, since `root` has other reference and `dummy` will not has any reference
     *        after method `flatten` return, finally `dummy` will be collected by GC after return.
     *
     * Base Cases:
     *     1. node == null; ---> return; // just return
     *
     * Corner Cases:
     *     2. root == null; ---> // doesn't need to handle, since main method `flatten` is a void method.
     *                              If return list head is required, return `dummy.right` is always right.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any Shape).
     *        avg   O(logn)
     */
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        helper(dummy, root);
    }

    private void helper(TreeNode dummy, TreeNode node) {
        if (node == null) {
            return;
        }
        helper(dummy, node.right);
        helper(dummy, node.left);
        node.left = null;
        node.right = dummy.right;
        dummy.right = node;
    }

    /**
     * Iteration Method (Pre-order, root->L->R)
     *
     * Problem Analysis:
     *     1. If doesn't have code `node.left = null`, the final result will not be a right skewed tree, please see below
     *            1               1                 1
     *           / \             / \              /   \
     *          2   5    --->    `->2    --->    2     2
     *         / \   \             / \          / \   / \
     *        3   4   6            `->3        3   3 3   3
     *                                 \        \   \ \   \
     *                                  4        4   4 4   4
     *                                   \        \   \ \   \
     *                                    5        5   5 5   5
     *                                     \        \   \ \   \
     *                                      6        6   6 6   6
     *     2. Build tree from pre-order, dummy->null, dummy->1->null, dummy->1->2>null, ..., dummy->1->2->3->4->5->6->null.
     *     3. `cur` is always the tail node of the linked list.
     *
     * Corner Cases:
     *     1. root == null; ---> return; // `Deque` interface not allow `null` element, otherwise will
     *                                      throw `NullPointerException` when call `stack.push` method.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(1), for skewed binary tree (Any shape). 
     *        worst O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        avg   O(logn)
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode head = new TreeNode(-1);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            head.right = cur;
            head.left = null;
            head = head.right;
        }
    }

    /**
     * Pre-order recursion traversal method
     *
     * Problem Analysis:
     *     1. If doesn't have code `node.left = null`, the final result will not be a right skewed tree, please see below
     *            1               1                 1
     *           / \             / \              /   \
     *          2   5    --->    `->2    --->    2     2
     *         / \   \             / \          / \   / \
     *        3   4   6            `->3        3   3 3   3
     *                                 \        \   \ \   \
     *                                  4        4   4 4   4
     *                                   \        \   \ \   \
     *                                    5        5   5 5   5
     *                                     \        \   \ \   \
     *                                      6        6   6 6   6
     *     2. Build tree from pre-order, dummy->null, dummy->1->null, dummy->1->2>null, ..., dummy->1->2->3->4->5->6->null.
     *     3. `cur` is always the tail node of the linked list.
     *     4. `dummy` will not lead to memory leak, since `root` has other reference and `dummy` will not has any reference
     *        after method `flatten` return, finally `dummy` will be collected by GC after return.
     *
     * Base Cases:
     *     1. node == null; ---> return cur; // which means `cur` cannot move to next node.
     *
     * Corner Cases:
     *     2. root == null; ---> // doesn't need to handle, since main method `flatten` is a void method.
     *                              If return list head is required, return `dummy.right` is always right.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any Shape).
     *        avg   O(logn)
     */
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        helper(dummy, root);
    }
    
    private TreeNode helper(TreeNode cur, TreeNode node) {
        if (node == null) {
            return cur;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        cur.right = node;
        cur = cur.right;
        cur = helper(cur, left); // now cur.right is no longer to be node.right, which is the tail of left subtree.
        cur = helper(cur, right);
        return cur;
    }
}
