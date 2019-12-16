


class Solution117 {
    /**
     * BFS method (queue not used). This problem cannot solved by DFS in O(n) time.
     *
     * Problem Analysis:
     *     1. The input tree is not a full binary tree, so we cannot use the solution of tree_106.java.
     *     2. The key point is hold layer 1 and connet layer 2, then switch layer 1 to layer 2, and the next layer of layer 2 becomes to new layer 2.
     *     3. `head` represents the level head (the leftmost start node) of each level.
     *     4. `dummy` is the level head of the next layer of the layer which `head` represented.
     *
     * General Cases:
     *     outer while loop:
     *         1. use `head != null` as condition
     *     inner while loop:
     *         1. head == null; ---> // do nothing
     *         2. head != null; ---> connet head.left or head.right of the next layer of `cur` represented.
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, return value `root` is null.
     *
     * Time:  O(n), binary tree has `n` nodes, the only way to get result is to traverse all the nodes.
     * Space: O(1), no any extra space been used.
     */
    public Node connect(Node root) {
        Node head = root;
        Node dummy = new Node(-1);
        while (head != null) {
            Node cur = dummy;
            while (head != null) {
                if (head.left != null) {
                    cur.next = head.left;
                    cur = cur.next;
                }
                if (head.right != null) {
                    cur.next = head.right;
                    cur = cur.next;
                }
                head = head.next;
            }
            head = dummy.next;
            dummy.next = null;
        }
        return root;
    }
}
