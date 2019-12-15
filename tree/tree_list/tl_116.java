


class Solution116 {
    /**
     * BFS method (queue not used)
     *
     * Problem Analysis:
     *     1. It's very important that the input tree is a perfect binary tree (full binary tree).
     *     2. `head` represents the level head (the leftmost start node) of each level.
     *
     * General Cases:
     *     outer while loop:
     *         1. use `head.left != null` as condition, to avoid `cur.left.next` throw `NullPointerException`.
     *     inner while loop:
     *         1. cur.next == null; ---> // do nothing
     *         2. cur.next != null; ---> cur.right.next = cur.next.left;
     *
     * Corner Cases:
     *     1. root == null; ---> return null; // otherwise `head.left != null` will throw `NullPointerException`.
     *
     * Time:  O(n), binary tree has `n` nodes, the only way to get result is to traverse all the nodes.
     * Space: O(1), no any extra space been used.
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node head = root;
        while (head.left != null) {
            Node cur = head;
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            head = head.left;
        }
        return root;
    }

    /**
     * DFS Method
     *
     * Base Cases:
     *     1. node.left == null; ---> return; // to avoid `node.left.next` throw `NullPointerException`.
     *
     * Corner Cases:
     *     1. root == null; ---> return null; // otherwise base case `node.left != null` will throw `NullPointerException`.
     *
     * Time:  O(n),  binary tree has `n` nodes, the only way to get result is to traverse all the nodes.
     * Space: O(logn), the height of perfect binary tree (full binary tree) is `logn`.
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return root;
    }
    
    private void helper(Node node) {
        if (node.left == null) {
            return;
        }
        node.left.next = node.right;
        node.right.next = node.next == null ? null : node.next.left;
        helper(node.left);
        helper(node.right);
    }
}
