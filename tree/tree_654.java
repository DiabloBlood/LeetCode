


class Solution654 {
    /**
     * DFS Method (Performance is bad)
     *
     * Problem Analysis:
     *     1. Find the max element and it's index for every recursive call.
     *     2. Find max index takes O(n) time for every layer of the binary tree.
     * 
     * Base Cases:
     *     1. start > end; ---> return null; // build `null` for a leaf node or a one-child node.
     *
     * Corner Cases:
     *     1. nums == null; ---> return null; // otherwise `nums.length - 1` will throw `NullPointerException`.
     *
     * Time:  best  O(nlogn), for height-balanced binary tree, complete binary tree, full binary tree,
     *                      in this case binary tree height is `logn`, every layer takes O(n) to find max element index.
     *        worst O(n^2), for skewed binary tree (Any shape), in this case every layer takes O(n - h) time,
     *                      total is `(n/2)^2` operations. Consider three example of worst cases,
     *                      [1, 2, 3, 5, 5, 6, 7, 8], [8, 7, 6, 5, 4, 3, 2, 1], [8, 6, 4, 2, 1, 3, 5, 7].
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int idx = start;
        for (int i = start + 1; i < end + 1; i++) {
            idx = nums[i] > nums[idx] ? i : idx;
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums, start, idx - 1);
        root.right = helper(nums, idx + 1, end);
        return root;
    }
}
