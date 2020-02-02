


class Solution117 {
    /**
     * BFS method (queue not used).
     *
     * Notes:
     *     1. `head` as level traversal pointer, which is first node of each level.
     *     2. `head` as 1st level traversal pointer.
     *     3. `cur` as 2nd level traversal pointer.
     *     4. `dummy` as dummy of each level.
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

    /**
     * More meaning clear method.
     *     1. `head` as level traversal pointer, which is first node of each level.
     *     2. `prev` as 1st level traversal pointer.
     *     3. `cur` as 2nd level traversal pointer.
     *     4. `dummy` as dummy of each level.
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
     *         1. prev == null; ---> // do nothing
     *         2. prev != null; ---> connet prev.left or prev.right at the next layer that `cur` represented.
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
            Node prev = head;
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
            head = dummy.next;
            dummy.next = null;
        }
        return root;
    }

    /**
     * DFS Method
     *
     * Problem Analysis:
     *     1. Use a path list to store the current tail node for each layer.
     *     2. Extra space of path list will be used.
     *
     * Base Cases:
     *     1. node == null; ---> return; // just return
     *
     * General Cases:
     *     1. depth == result.size(); ---> list.add(node); // add the leftmost node of layer depth to path list
     *     2. depth <  result.size(); ---> list.get(depth).next = node;
     *                                     list.set(depth, node); // make node at position depth as current tail node.
     *     3. depth >  result.size(); ---> // impossible
     *
     * Corner Cases:
     *     1. root == null; ---> // doesn't need to handle, already handled by base cases,
     *                              return value `root` is `null`;
     *
     * Time:  O(n), binary tree contains `n` nodes, the only way to get result is to traverse all the nodes.
     * Space: best  O(2logn), for height-balanced binary tree, complete binary tree, full binary tree.
     *                        Path list takes `logn`, implicit stack takes another `logn`.
     *        worst O(2n), for skewed binary tree (Any shape). Path list takes `n`, implicit stack takes another `n`;
     *        avg   O(2logn)
     */
    public Node connect(Node root) {
        helper(new ArrayList<>(), 0, root);
        return root;
    }

    private void helper(List<Node> list, int depth, Node node) {
        if (node == null) {
            return;
        }
        if (depth == list.size()) {
            // reach the leftmost node of layer depth, add it as `head`
            list.add(node);
        } else {
            list.get(depth).next = node;
            list.set(depth, node);
        }
        helper(list, depth + 1, node.left);
        helper(list, depth + 1, node.right);
    }
}
