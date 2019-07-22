


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
}