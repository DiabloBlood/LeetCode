


class Solution105 {
    /**
     * Problem Pitfalls:
     *     1. No duplicates is very important, otherwise it's impossible to use a hashmap
     *        to store `value->index` relationship of `inorder` array.
     *
     * Problem Analysis:
     *     1. Create a node for every recursive all, use a hashmap to store `value->index` relationship of `inorder` array.
     *     2. Why base cases not check if `pre` is out of bound, only check if `inStart > inEnd`?
     *        Please see as follow, only `inStart > inEnd` determines a node is `null`.
     *
     *        Input: preorder [3, 9, 20, 15, 7]
     *               inorder  [9, 3, 15, 20, 7]
     *
     *               ----3----                             -------(0, 0, 4)-------
     *             /           \                         /                         \
     *            9          --20--                 (1, 0, 0)              ----(2, 2, 4)----
     *          /   \      /        \              /         \           /                   \
     *        null null  15          7        (2, 0, -1) (2, 0, -1)  (3, 2, 2)            (4, 4, 4)
     *                 /    \      /   \                            /         \          /         \
     *               null  null  null null                      (4, 2, 1) (4, 3, 2)  (5, 4, 3) (5, 5, 4)
     *
     * Base Cases:
     *     1. inStart > inEnd; ---> return null; // please refer explaination of [Problem Analysis 2].
     *
     * Corner Cases:
     *     1 . preorder.length == inorder.length && from array `preorder` and array `inorder` cannot re-build a binary tree;
     *        ---> // impossible, situation that array `preorder` and `inorder` both are valid is pre-guaranteed.
     *     2. preorder.length != inorder.length; ---> return null;
     *     3. preorder == null && inorder == null; ---> return null;
     *     4. preorder.length == 0 && inorder.length == 0; ---> // doesn't need to handled, already been handled by base cases.
     *
     * Time:  O(n), every recursive call will create a node, binary tree has `n` nodes.
     *              if don't use hashmap, every recursive call will has O(n) overhead to find root `idx` of `inorder` array,
     *              then finally time complexity rises to O(n^2).
     * Space: best  O(n + logn), for height-balanced binary tree, complete binary tree, full binary tree,
     *                           hashmap takes `n`, implicit stack takes `logn`.
     *        worst O(2n), for skewed binary tree (Any shape), hashmap takes `n`, implicit stack takes `n`.
     *        avg   O(n + logn)
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
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
}
