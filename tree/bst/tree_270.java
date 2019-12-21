


class Solution700 {
	/**
     * Problem Analysis:
     *     1. BST property, all nodes of left subtree < root.val, all nodes of right subtree > root.val,
     *        and this is a recursive definition.
     *     2. Non-empty BST and one unique value in the BST that is closest are guaranteed.
     *     3. For any root of subtrees, assume left subtree, root, right subtree ranges likes
     *        [a, x) x (x, b], then if target < x, the closest node must is root or in the left subtree,
     *        if target > x, the closest node must is root or in the right subtree, so put root.val as a potential
     *        result, then find the potentially more precise result in the corresponding subtree.
     * 
     * General Cases:
     *     1. root == null;   ---> while loop break;
     *     2. root.val > val; ---> root = root.left;
     *     3. root.val < val; ---> root = root.right;
     * 
     * Corner Cases:
     *     1. root = null; ---> throw new IllegalArgumentException(); // otherwise `int result = root.val`
     *        will throw `NullPointerException`. But Non-empty BST is already guaranteed.
     * 
     * Time:  best  O(logn), for height-balanced BST, complete BST, full BST. Not traverse all nodes, only traverse a path, branch pruning.
     *                       But the path must be completely traversed to get result.
     *        worst O(n), for skewed BST (Any shape).
     *        avg   O(logn)
     * Space:       O(1), no extra space used.
     */
	public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        int result = root.val;
        while (root != null) {
            result = Math.abs(result - target) < Math.abs(root.val - target) ? result : root.val;
            root = root.val > target ? root.left : root.right;
        }
        return result;
    }

    /**
     * A method with small optimization.
     * 
     * Problem Analysis:
     *     1. For any root of subtrees, assume left subtree, root, right subtree ranges likes
     *        [a, x) x (x, b], if all node value is integer, ranges should like [a, x - 1] x [x + 1, b],
     *        so if abs(target - x) < 0.5, the closest node must be this root.
     *     2. If all node value is float/double, only method above could be used.

     * Time:  best  O(1), now could find result very early, doesn't need to traverse complete path.
     *        best  O(logn), for height-balanced BST, complete BST, full BST. Not traverse all nodes, only traverse a path, branch pruning.
     *        worst O(n), for skewed BST (Any shape).
     *        avg   O(logn)
     * Space:       O(1), no extra space used.
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        int result = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(result - target)) {
                result = root.val;
                if (Math.abs(root.val - target) < 0.5) {
                    break;
                }
            } 
            root = root.val > target ? root.left : root.right;
        }
        return result;
    }
}
