pending:
    - 1, 15, 202, 3, 22, 42

finished
    - 20

one pass
    - 20



 */
    /**
     * Problem Pitfalls:
     *     1. Input array is not sorted and has duplicates, sort this array could get result in O(n^2).
     *     2. For input case likes [0, 0, 0, 0, 0], triplet index is (0, 3, 4), others is impossible.
     *     3. For input case likes [-10, -10, 5, 5, 5, 5], triplet index is (0, 2, 5), others is impossible.
     *     4. For three pointers i, j, k, if has duplicates, always use the first appeared index as result.
     *        Otherwise, for input case [0, 0, 0, 0, 0], `i` will finally go to index 3,
     *        for input case [-10, -10, 5, 5, 5, 5], `j` will go to index 5, `k` will go to index 3,
     *        finally will not get any result.
     *
     * Problem Analysis:
     *     1. Use condition `i > 0 && nums[i] == nums[i - 1]` to skip duplicate number at `i` position,
     *        this condition will guarantee always use first appeared duplicate number.
     *
     * General Cases:
     * for loop:
     *     1. a >  0; ---> break; // which means a + b + c > 0, since a < b < c.
     *     2. a <= 0; ---> while loop
     *     while loop:
     *         1. a + b >  0;                   ---> break; // which means a + b + c > 0
     *         2. a + b <= 0 && a + b + c <  0; ---> j++;
     *         3. a + b <= 0 && a + b + c >  0; ---> k--;
     *         4. a + b <= 0 && a + b + c == 0; ---> add triplet
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (nums[j] == nums[i]) {
              j++;
            }
            while (j < k) {

            } 
        }
    }


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
