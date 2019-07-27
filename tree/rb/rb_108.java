


class Solution108 {
    /**
     * Notes:
     *     1. What is height-balanced BST? Sub-tree height diff no more than 1.
     *     2. BST property, left tree < root.val, right tree > root.val. This array is sorted.
     *     3. How about this array has duplicates? Then become left tree <= root.val, right tree >= root.val.
     * 
     * Time:  O(n), every recursive call will generate a node.
     * Space: O(logn), since this BST is a hight-balanced BST.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}
