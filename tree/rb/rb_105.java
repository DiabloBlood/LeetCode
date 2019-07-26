


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
}
