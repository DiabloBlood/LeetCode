


class Solution110 {
    /**
     * Time:  O(n)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -2;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);
        if (leftHeight != -2 && rightHeight != -2 && Math.abs(leftHeight - rightHeight) <= 1) {
            return 1 + Math.max(leftHeight, rightHeight);
        }
        return -2;
    }


    /**
     * Time:  O(n)
     * Space: best O(logn) of complete binary tree, worst O(n) of flat list tree
     */
    private class MyResult {
        boolean bal;
        int height;
        MyResult(boolean bal, int height) {
            this.bal = bal;
            this.height = height;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return helper(root).bal;
    }
    
    private MyResult helper(TreeNode node) {
        if(node == null) {
            return new MyResult(true, -1);
        }
        MyResult left = helper(node.left);
        MyResult right = helper(node.right);
        boolean bal = left.bal && right.bal && Math.abs(left.height - right.height) <= 1;
        return new MyResult(bal, 1 + Math.max(left.height, right.height));
    }
}