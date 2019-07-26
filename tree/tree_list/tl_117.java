


class Solution117 {
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