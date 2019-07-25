

/**
 * Notes: Please make sure corner case `root == null`, which will return `Integer.MIN_VALUE`.
 */
class Solution124 {
    int max = Integer.MIN_VALUE;

    /**
     * Case Analysis:
     * 1. left < 0 && right < 0; max = max(max, node.val + 0 + 0);
     * 2. left < 0 && right >= 0; max = max(max, node.val + right + 0);
     * 3. left >= 0 && right < 0; max = max(max, node.val + left + 0);
     * 4. left >= 0 && right >= 0; max = max(max, node.val + left + right);
     * 
     * RV: return node.val + max(left, right);

     * Time:  O(n), the only way to get result is to traverse all the nodes
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        
        max = Math.max(max, node.val + left + right);
        return node.val + Math.max(left, right);             
    }

    /**
     * Case Analysis:
     * 1. left < 0 && right < 0; max = max(max, node.val + 0 + 0);
     * 2. left < 0 && right >= 0; max = max(max, node.val + right + 0);
     * 3. left >= 0 && right < 0; max = max(max, node.val + left + 0);
     * 4. left >= 0 && right >= 0; max = max(max, node.val + left + right);
     * 
     * RV: return node.val + max(left, right);

     * Time:  O(n), the only way to get result is to traverse all the nodes
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        helper(result, root);
        return result[0];
    }
    
    private int helper(int[] result, TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = Math.max(helper(result, node.left), 0);
        int right = Math.max(helper(result, node.right), 0);
        
        result[0] = Math.max(result[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
