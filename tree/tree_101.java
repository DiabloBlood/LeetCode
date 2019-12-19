


class Solution101 {
    /**
     * Method Tags:
     *     1. Bottom Up.
     *
     * Problem Analysis:
     *     1. If we invert the right subtree first (like tree_226.java), then this problem converted to a same tree problem. (tree_100.java)
     *     2. In fact, we don't need to invert a subtree, just recursively call isSame(p.left, q.right) and isSame(p.right, q.left).
     *     3. This problem could get result without traverse the whole tree.
     *
     * Base Cases:
     *     1. p == null && q == null; ---> return true; // case 1: `null` from a leaf node.
     *                                                  // case 2: `null` from a one-child parent node.
     *     2. p == null && q != null; ---> return false;
     *     3. p != null && q == null; ---> return false;
     *     4. p != null && q != null && p.val != q.val; ---> return false;
     *     combine 2, 3, 4:
     *     2. p == null || q == null || p.val != q.val; ---> return false
     *
     * General Cases:
     *     1. p != null && q != null && p.val == q.val && isSym(p.left, q.right) == false && isSym(p.right, q.left) == false;  ---> return false;
     *     2. p != null && q != null && p.val == q.val && isSym(p.left, q.right) == false && isSym(p.right, q.left) ==  true;  ---> return false;
     *     3. p != null && q != null && p.val == q.val && isSym(p.left, q.right) == true  && isSym(p.right, q.left) == false;  ---> return false;
     *     4. p != null && q != null && p.val == q.val && isSym(p.left, q.right) == true  && isSym(p.right, q.left) ==  true;  ---> return true;
     *     combine 1, 2, 3, 4:
     *     1. return isSym(p.left, q.right) && isSym(p.right, q.left);
     *        // if base cases not return, then `p != null && q != null && p.val == q.val` already guranteed.
     *
     * Corner Cases:
     *     1. root == null; ---> return true; // must be handled, otherwise `root.left` and `root.right` will throw `NullPointerException`.
     * 
     * Time:  best  O(1), detected `p` and `q` is not symmetric at root level (could get result without traverse the whole tree).
     *        worst O(n/2), each subtree contains `n/2` nodes.
     * Space: best  O(1), detected `p` and `q` is not symmetric at root level (could get result without traverse the whole tree).
     *        avg   O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n/2), for each subtree is a skewed binary tree (Any shape).
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return helper(p.left, q.right) && helper(p.right, q.left);
    }

    /**
     * Method Tags:
     *     1. Iteration Method (Use explicit stack).
     *
     * Base Cases:
     *     1. p == null && q == null; ---> continue; // case 1: `null` from a leaf node.
     *                                               // case 2: `null` from a one-child parent node.
     *        // just `continue` if us explicit stack, to avoid push any node to stack equal to return from the bottom of recursion tree.
     *     2. p == null && q != null; ---> return false;
     *     3. p != null && q == null; ---> return false;
     *     4. p != null && q != null && p.val != q.val; ---> return false;
     *     combine 2, 3, 4:
     *     2. p == null || q == null || p.val != q.val; ---> return false
     *
     * General Cases:
     *     No general cases, since explicit stack could return in any stack level. (Implicit stack could only return at root level)
     *     1. just push nodes to stack.
     *
     * Corner Cases:
     *     1. root == null; ---> return true; // must be handled, otherwise `root.left` or `root.right` will throw `NullPointerException`.
     *
     * Time:  best  O(1), detected `p` and `q` is not symmetric at root level (could get result without traverse the whole tree).
     *        worst O(n/2), each subtree contains `n/2` nodes.
     *        avg   O(n)
     * Space: best  O(1), detected `p` and `q` is not symmetric at root level (could get result without traverse the whole tree).
     *        best  O(1), for each subtree is a skewed binary tree (Any shape).
     *        worst O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        avg   O(logn)
     */
    private class Node {
        TreeNode p;
        TreeNode q;
        Node (TreeNode node1, TreeNode node2) {
            p = node1;
            q = node2;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(root.left, root.right));
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.p == null && cur.q == null) {
                continue;
            }
            if (cur.p == null || cur.q == null || cur.p.val != cur.q.val) {
                return false;
            }
            stack.push(new Node(cur.p.right, cur.q.left));
            stack.push(new Node(cur.p.left, cur.q.right));
        }
        return true;
    }
}
