


class Solution426 {
    /**
     * DFS method, in-order traversal and not use global variable.
     * 
     * Problem Analysis:
     *     1. `temp.right` likes global variable `cur`.
     *
     * Base Cases:
     *     1. node == null; ---> return; // just return
     *
     * Corner Cases:
     *     1. root == null; ---> return null; // otherwise `dummy.right.left` will throw `NullPointerException`.
     *     2. root.left == null && root.right == null; ---> // doesn't need to handle, finally `root.left == root && root.right == root`;
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(-1);
        Node temp = new Node(-1);
        temp.right = dummy;
        helper(temp, root);
        temp.right.right = dummy.right;
        dummy.right.left = temp.right;
        return dummy.right;
    }
    
    private void helper(Node temp, Node node) {
        if (node == null) {
            return;
        }
        helper(temp, node.left);
        temp.right.right = node;
        node.left = temp.right;
        temp.right = node;
        helper(temp, node.right);
    }

    /**
     * Use global variable
     *
     * Base Cases:
     *     1. node == null; ---> return; // just return
     *
     * Corner Cases:
     *     1. root == null; ---> return null; // otherwise `dummy.right.left` will throw `NullPointerException`.
     *     2. root.left == null && root.right == null; ---> // doesn't need to handle, finally `root.left == root && root.right == root`;
     *
     * Time:  O(n), binary tree contains `n` nodes.
     * Space: best  O(logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *        worst O(n), for skewed binary tree (Any shape).
     *        avg   O(logn)
     */
    private Node dummy = new Node(-1);
    private Node cur = dummy;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        cur.right = dummy.right;
        dummy.right.left = cur;
        return dummy.right;
    }
    
    private void helper(Node node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        cur.right = node;
        node.left = cur;
        cur = cur.right;
        helper(node.right);
    }
}
