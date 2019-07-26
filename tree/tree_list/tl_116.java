


class Solution116 {
    /**
     * Case Analysis:
     * Notes: `head` represents the level head (the left most start node) of each level.
     * 1. `root == null` corner case should be handle,
     *    to avoid while loop `head.left != null` condition throw `NullPointerException`.
     * 2. `head.left != null` to avoid `cur.next.left` throw `NullPointerException`.
     *
     * Time:  O(n), the only way to get result is to traverse all the nodes.
     * Space: O(1)
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
     * Case Analysis:
     * 1. `root == null` corner case should be handle,
     *     to avoid recursion bottom condition `node.left == null` throw `NullPointerException`.
     * 2. `node.left != null` to avoid `node.left.next` throw `NullPointerException`.
     *
     * Time:  O(n), the only way to get result is to traverse all the nodes.
     * Space: O(logn)
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
