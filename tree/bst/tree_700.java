


class Solution700 {
    /**
     * Problem Analysis:
     *     1. BST property, all nodes of left subtree < root.val, all nodes of right subtree > root.val,
     *        and this is a recursive definition.
     * 
     * General Cases:
     *     1. root == null;                    ---> while loop break;
     *     2. root != null && root.val == val; ---> while loop break;
     *     3. root != null && root.val != val && root.val > val; ---> root = root.left;
     *     4. root != null && root.val != val && root.val < val; ---> root = root.right;
     * 
     * Corner Cases:
     *     1. root = null; ---> // doesn't need to handle, while loop will be skipped and return value is `null`.
     * 
     * Time:  best  O(1), could find result very early, branch pruning.
     *        best  O(logn), for height-balanced BST, complete BST, full BST. Not traverse all nodes, only traverse a path, branch pruning.
     *        worst O(n), for skewed BST (Any shape).
     *        avg   O(logn)
     * Space:       O(1), no extra space used.
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }

    /**
     * Problem Analysis:
     *     1. BST property, all nodes of left subtree < root.val, all nodes of right subtree > root.val,
     *        and this is a recursive definition.
     *
     * Base Cases:
     *     1. root == null;    ---> return null; // which means not find a node that `node.val == val`.
     *     2. root.val == val; ---> return root; // node with `node.val == val` found.
     *
     * General Cases:
     *     1. root.val > val; ---> return searchBST(root.left, val);
     *     2. root.val < val; ---> return searchBST(root.right, val);
     * 
     * Corner Cases:
     *     1. root = null; ---> // doesn't need to handle, already handled by base cases.
     * 
     * Time:  best  O(1), could find result very early, branch pruning.
     *        best  O(logn), for height-balanced BST, complete BST, full BST. Not traverse all nodes, only traverse a path, branch pruning.
     *        worst O(n), for skewed BST (Any shape).
     *        avg   O(logn)
     * Space: best  O(1), could find result very early, branch pruning.
     *        best  O(logn), for height-balanced BST, complete BST, full BST.
     *        worst O(n), for skewed BST (Any shape).
     *        avg   O(logn)
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
