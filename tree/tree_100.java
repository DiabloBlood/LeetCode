


class Solution100 {
    /**
     * Method Tags:
     *     1. Bottom Up. (Could stop at internal nodes)
     *
     * Base Cases:
     *     1. p == null && q == null; ---> return true; // `null` has two kind of cases, from leaf node or from non-leaf node.
     *     2. p == null && q != null; ---> return false;
     *     3. p != null && q == null; ---> return false;
     *     4. p != null && q != null && p.val != q.val; ---> return false;
     *     combine 2, 3, 4:
     *     2. p == null || q == null || p.val != q.val; ---> return false;
     *
     * General Cases:
     *     1. p != null && q != null && p.val == q.val && isSame(left) == false && isSame(right) == false;  ---> return false;
     *     2. p != null && q != null && p.val == q.val && isSame(left) == false && isSame(right) ==  true;  ---> return false;
     *     3. p != null && q != null && p.val == q.val && isSame(left) == true  && isSame(right) == false;  ---> return false;
     *     4. p != null && q != null && p.val == q.val && isSame(left) == true  && isSame(right) ==  true;  ---> return true;
     *     combine 1, 2, 3, 4:
     *     1. return isSame(left) && isSame(right); // if base cases not return, then `p != null && q != null && p.val == q.val` already guranteed.
     *
     * Corner Cases:
     *     1. root of tree `p` is null || root of tree `q` is null; ---> // doesn't need to handle, already handled by base cases.
     * 
     * Time:  best  O(1), detected `p` and `q` is not same tree at root level.
     *        worst O(n), binary tree contains `n` nodes.
     * Space: best  O(1), detected `p` and `q` is not same tree at root level.
     *        avg   O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any Shape).
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}