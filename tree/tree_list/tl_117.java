


class Solution117 {
    /**
     * Case Analysis:
     * 1. No need to handle `root == null` corner case, since it already included in the general cases.
     * 2. `cur.next == null` is for initialize dummy node at every level beginning. Otherwise, endless loop will occur.
     *
     * Time:  O(n), the only way to get result is to traverse all the nodes.
     * Space: O(1)
     */
    public Node connect(Node root) {
        Node dummy = new Node(-1);
        Node prev = root;
        while (prev != null) {
            Node cur = dummy;
            cur.next = null;
            while (prev != null) {
                if (prev.left != null) {
                    cur.next = prev.left;
                    cur = cur.next;
                }
                if (prev.right != null) {
                    cur.next = prev.right;
                    cur = cur.next;
                }
                prev = prev.next;
            }
            prev = dummy.next;
        }
        return root;
    }
}
