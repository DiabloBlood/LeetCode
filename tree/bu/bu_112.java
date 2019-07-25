


class Solution112 {
    /**
     * Case Analysis:
     * 1. root == null; return false;
     * 2. root.left == null && root.right == null && sum - root.val == 0; return true;
     * 3. return func(root.left, sum - root.val) || func(root.right, sum - root.val);
     *
     * Time:  Worst O(n), which means cannot find a path or the path is the right most path
     *        Best  O(1)
     *        Avg   O(n)
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }, 1
        int nextSum = sum - root.val;
        if (root.left == null && root.right == null && nextSum == 0) {
            return true;
        }
        return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
    }
}