


class Solution108 {
    /**
     * Notes:
     *     1. What is height-balanced BST? Sub-tree height diff no more than 1.
     *     2. BST property, left tree < root.val, right tree > root.val. This array is sorted.
     *     3. How about this array has duplicates? Then become left tree <= root.val, right tree >= root.val.
     *
     * Problem Analysis:
     *     1. Re-build this tree from pre-order.
     *     2. Why use `start > end` as base cases? Please see as follow,
     *        Input: [-10, -3, 0, 5, 9]
     *                                                  (start, end, mid)
     *               ---0---                             --(0, 4, 2)--
     *             /         \                         /               \
     *           -10          5                (0, 1, 0)            (3, 4, 3)
     *          /   \       /   \             /         \          /         \
     *        null  -3    null   9        (0, -1)    (1, 1, 1)  (3, 2)    (4, 4, 4)
     *             /   \       /   \                /         \          /         \
     *           null null   null null           (1, 0)     (2, 1)    (4, 3)     (5, 4)
     *
     *     3. Why every recursive call use `mid` as `root` will build a height-balanced BST?
     *        Use mathmetical induction to prove this theorem, please see as follow, we could know that when `k >= 1`, if array has `2k + 1`
     *        elements, tree structure is `k, root, k`, if array has `2k + 2` elements, tree structure is ` k, root, k + 1`, so the difference
     *        of height of left subtree and right subtree at most is `floor(log(2k+2)) - floor(log(2k+1))`, which is only `0` or `1`.
     *
     *        elements    structure            height    isHeightBal
     *               0    null                      0              Y
     *               1    null, root, null          1              Y
     *               2    null, root, 1             2              Y
     *               3    1, root, 1                2              Y
     *               4    1, root, 2                3              Y
     *               5    2, root, 2                3              Y
     *               6    2, root, 3                3              Y
     *               7    3, root, 3                3              Y
     *               8    3, root, 4                4              Y
     *               9    4, root, 4                4              Y
     *          ......
     *              15    7, root, 7                4              Y
     *              16    7, root, 8                5              Y
     *          ......
     *          2k + 1    k, root, k         1 + log(2k+1)         Y
     *          2k + 2    k, root, k + 1     1 + log(2k+2)         Y
     *
     * Base Cases:
     *     1. start > end; ---> return null;
     *
     * Corner Cases:
     *     1. nums == null; ---> return null;
     *
     * Time:  O(n), every recursive call will create a node.
     * Space: O(logn), since this BST is a hight-balanced BST, tree height must be `logn`.
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

    /**
     * Build from inorder traversal.
     *
     * Notes:
     *     1. It is ok not to use auto increment idx.
     *
     * Time:  O(n), every recursive call will generate a node.
     * Space: O(logn), since this BST is a hight-balanced BST.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] idx = new int[1];
        return helper(nums, idx, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int[] idx, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = helper(nums, idx, start, mid - 1);
        // which has mid == idx[0];
        TreeNode root = new TreeNode(nums[idx[0]++]);
        root.left = left;
        root.right = helper(nums, idx, mid + 1, end);
        return root;
    }
}
