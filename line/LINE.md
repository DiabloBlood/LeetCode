pending:
    - 1, 202, 3, 22, 42, 76, 937, 31, 49, 11, 7, 221, 994
    - 32, 125, 819, 238, 169, 217, 167, 16, 18, 287, 229
    - 189, 84, 13, 6, 14, 12, 38, 67, 151, 8, 557, 28

finished
    - 20, 15, 344

one pass
    - 344, 20

two pass
    - 15

    /**
     * Problem Analysis:
     *     1.
     *
     * General Cases:
     *     1.
     *
     * Corner Cases:
     *     1.
     *
     * Time:
     * Space:
     */

    // dummy.next likes cur
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        dummy.right = new TreeNode(-1);
        helper(dummy, root);
    }
    
    private void helper(TreeNode dummy, TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode right = node.right;
        dummy.right.right = node;
        dummy.right = node;
        helper(node.left);
        helper(right);
    }

    /**
     * Problem Analysis:
     *     1. If doesn't have code `root.left = null`, final result will not a right skewed tree, please see below
     *          1               1                            1
     *         / \             / \                           
     *        2   5    --->    `->2            
     *       / \   \             / \
     *      3   4   6            `->3
     *                               \
     *                                4
     *                                 \
     *                                  5
     *                                   \
     *                                    6
     */
    private TreeNode dummy = new TreeNode(-1);
    private TreeNode cur = dummy;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        cur.right = root;
        cur = cur.right;
        flatten(left);
        flatten(right);
    }

    private TreeNode dummy = new TreeNode(-1);
    private TreeNode cur = dummy;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        cur.right = root;
        cur = cur.right;
        flatten(root.left);
        flatten(right);
    }
