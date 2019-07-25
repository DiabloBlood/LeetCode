


class Solution111 {

    /**
     * Case Analysis:
     * 1. left == 0 && right == 0; return left + right + 1; // return min(left, right) + 1 is OK
     * 2. left == 0 && right != 0; return right + 1; //return left + right + 1 is OK
     * 3. left != 0 && right == 0; return left + 1;// return left + right + 1 is OK
     * 4. left != 0 && right != 0; return min(left, right) + 1;
     *
     * Time:  O(n), the only way to get result is to traverse all the nodes
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    /**
     * Case Analysis:
     * 1. left == -1 && right == -1; return depth;
     * 2. left == -1 && right != -1; return right;
     * 3. left 1= -1 && right == -1; return left;
     * 4. left != -1 && right != -1; return min(left, right);
     *
     * Time:  O(n), the only way to get result is to traverse all the nodes
     * Space: Best  O(logn) for balanced tree.
     *        Worst O(n) for flat list tree.
     */
    public int minDepth(TreeNode root) {
        return helper(root, 0) + 1;
    }
    
    private int helper(TreeNode node, int depth) {
        if (node == null) {
            return -1;
        }
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left == -1 && right == -1) {
            return depth;
        }
        return left == -1 ? right : left;
    }
}