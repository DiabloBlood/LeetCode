


class Solution105 {

    /**
     * Case Analysis:
     *      3
     *     / \
     *    9  20
     *      /  \
     *     15   7
     * Input: preorder [3,9,20,15,7]
     *         inorder [9,3,15,20,7]
     * 
     * Notes: Assume no duplicates is very important!!!
     * 1. Recursion buttom condition no need to check pre index out of bound.
     * 
     * Time:  O(n), every recursive call will generate a node.
     * Space: O(n), O(n) for map, O(logn) ~ O(n) for implicit stack.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Assume input is currect
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, 0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(Map<Integer, Integer> map, int pre, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre]);
        int index = map.get(root.val);
        root.left = helper(map, pre + 1, inStart, index - 1, preorder, inorder);
        root.right = helper(map, pre + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }

        /**
     * Case Analysis:
     *      3       (0, 0, 4)
     *     / \
     *    9  20     (1, 0, 0)
     *      /  \
     *     15   7
     * Input: preorder [3,9,20,15,7]
     *         inorder [9,3,15,20,7]
     *
     *          3
     *      /       \
     *     9        --20--
     *   /   \     /
     * null null   15        7
     *           /    \      /   \
     *         null  null  null null
     * Problem Pitfalls:
     *     1. No duplicates is very important, otherwise it's impossible use a hashmap
     *        to store `value->index` relationship of `inorder` array.
     *
     * Problem Analysis:
     *     1.
     * Notes: Assume no duplicates is very important!!!
     * 1. Recursion buttom condition no need to check pre index out of bound.
     * 
     * Time:  O(n), every recursive call will generate a node.
     * Space: O(n), O(n) for map, O(logn) ~ O(n) for implicit stack.
     */
    /**
     * Corner Cases:
     *     1. preorder.length == inorder.length, array `preorder and `inorder` both are valid is pre-guaranteed.
     *     2. preorder == null && inorder == null; ---> return null;
     *     3. preorder.length == 0 && inorder.length == 0; ---> return null;
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, 0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(Map<Integer, Integer> map, int pre, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre]);
        int idx = map.get(preorder[pre]);
        root.left = helper(map, pre + 1, inStart, idx - 1, preorder, inorder);
        root.right = helper(map, pre + idx - inStart + 1, idx + 1, inEnd, preorder, inorder);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode helper(Map<Integer, Integer> map, int post, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post]);
        int idx = map.get(postorder[post]);
        root.left = helper(map, post - inEnd + idx - 1, inStart, idx - 1, inorder, postorder);
        root.right = helper(map, post - 1, idx + 1, inEnd, inorder, postorder);
        return root;
    }
}
