


class Solution156 {
    /**
     * Time: O(n), while loop operation times between `n/2` to `n`,
     *     `n/2` means right leaves is full, `n` means no right leaves.
     * Space: O(1) 
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode right = null;
        while (root != null) {
            TreeNode tempRight = root.right;
            TreeNode temp = root.left;
            root.left = right;
            root.right = prev;
            prev = root;
            root = temp;
            right = tempRight;
        }
        return prev;
    }
}
