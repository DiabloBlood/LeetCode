


class Solution145 {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        helper(result, node.left);
        helper(result, node.right);
        result.add(node.val);
    }

    /**
     * Iteration Method
     *
     * Key Points:
     *     1. Post order is `L->R->root`, which is reverse of `root->R->L`, very like pre-order `root->L->R`.
     *     2. Linked list insert at head operation overhead is O(1).
     *
     * Corner Cases:
     *     1. root == null; ---> return new LinkedList<>();
     *        // `Deque` interface not allow `null` element, otherwise will throw `NullPointerException` when call `stack.push` method.
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(1), for skewed binary tree. (Any shape of skewed binary tree, left skewed, right skewed, or zigzag shape)
     *        worst O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        avg   O(logn)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(0, cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return result;
    }

    /**
     * Case Analysis of second while loop:
     * I.
     * Notes: After first while loop, cur must be `null`.
     * 1. !s.isEmpty() && right == null && right != cur; cur = s.pop(); add(cur.val);
     * 2. !s.isEmpty() && right == null && right == cur; cur = s.pop(); add(cur.val);
     * 3. !s.isEmpty() && right != null && right != cur; cur = right; break;
     * 4. !s.isEmpty() && right != null && right == cur; cur = s.pop(); add(cur.val);
     * 
     * II. After second while loop finished, if stack.isEmpty(), now cur is root again,
     *     the outer while loop should be break.
     * Notes: right != cur check is for "cur cannot go back at right most leaf";
     *
     * Time:  O(n)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        do {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            while (!stack.isEmpty()) {
                TreeNode right = stack.peek().right;
                if (right != null && right != cur) {
                    cur = right;
                    break;
                }
                cur = stack.pop();
                result.add(cur.val);
            }
        } while (!stack.isEmpty());
        return result;
    }

    /**
     * Time:  O(n)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                result.add(0, cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        return result;
    }
}
