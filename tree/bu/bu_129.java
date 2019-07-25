


class Solution129 {
    /**
     * Time:  O(n), the only way to get result is to traverse all the nodes
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }
        int sum = prevSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        
        return helper(node.left, sum) + helper(node.right, sum);
    }
}
