


class Solution106 {

    /**
     * Case Analysis:
     *      3
     *     / \
     *    9  20
     *      /  \
     *     15   7
     * Input: inorder [9,3,15,20,7]
     *        preorder [9,15,7,20,3]
     * 
     * Notes: Assume no duplicates is very important!!!
     * 1. Recursion buttom condition no need to check pre index out of bound.
     * 
     * Time:  O(n), every recursive call will generate a node.
     * Space: O(n), O(n) for map, O(logn) ~ O(n) for implicit stack.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Assume input is correct
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
        int index = map.get(root.val);
        root.left = helper(map, post - inEnd + index - 1, inStart, index - 1, inorder, postorder);
        root.right = helper(map, post - 1, index + 1, inEnd, inorder, postorder);
        return root;
    }
}
