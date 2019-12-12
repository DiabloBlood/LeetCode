


class Solution106 {
    /**
     * Problem Pitfalls:
     *     1. No duplicates is very important, otherwise it's impossible to use a hashmap
     *        to store `value->index` relationship of `inorder` array.
     *
     * Problem Analysis:
     *     1. Create a node for every recursive all, use a hashmap to store `value->index` relationship of `inorder` array.
     *     2. Why base cases not check if `post` is out of bound, only check if `inStart > inEnd`?
     *        Please see as follow, only `inStart > inEnd` determines a node is `null`.
     *
     *        Input: inorder   [9, 3, 15, 20, 7]
     *               postorder [9, 15, 7, 20, 3]
     *
     *               ----3----                             -------(4, 0, 4)-------
     *             /           \                         /                         \
     *            9          --20--                 (0, 0, 0)              ----(3, 2, 4)----
     *          /   \      /        \              /         \           /                   \
     *        null null  15          7        (-1, 0, -1) (-1, 1, 0) (1, 2, 2)            (2, 4, 4)
     *                 /    \      /   \                            /         \          /         \
     *               null  null  null null                      (0, 2, 1) (0, 3, 2)  (1, 4, 3)  (1, 5, 4)
     *
     * Base Cases:
     *     1. inStart > inEnd; ---> return null; // please refer explaination of [Problem Analysis 2].
     *
     * Corner Cases:
     *     1. inorder.length == postorder.length && from array `inorder` and array `postorder` cannot re-build a binary tree;
     *        ---> // impossible, situation that array `preorder` and `inorder` both are valid is pre-guaranteed.
     *     2. inorder.length != postorder.length; ---> return null;
     *     3. inorder == null && postorder == null; ---> return null;
     *     4. inorder.length == 0 && postorder.length == 0; ---> // doesn't need to handled, already been handled by base cases.
     *
     * Time:  O(n), every recursive call will create a node, binary tree has `n` nodes.
     *              if don't use hashmap, every recursive call will has O(n) overhead to find root `idx` of `inorder` array,
     *              then finally time complexity rises to O(n^2).
     * Space: best  O(n + logn), for height-balanced binary tree, complete binary tree, full binary tree,
     *                           hashmap takes `n`, implicit stack takes `logn`.
     *        worst O(2n), for skewed binary tree (Any shape), hashmap takes `n`, implicit stack takes `n`.
     *        avg   O(n + logn)
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
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
