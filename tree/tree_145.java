


class Solution145 {
    /**
     * Time:  O(n)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree.
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
     * Space: best O(1) of flat list tree, worst O(logn) of complete binary tree.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
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
