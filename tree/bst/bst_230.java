


class Solution230 {
    /**
     * Time: O(k)
     * Space: O(logn)
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int result = Integer.MIN_VALUE;
        while ((!stack.isEmpty() || cur != null) && k > 0) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            result = cur.val;
            cur = cur.right;
        }
        return result;
    }
}