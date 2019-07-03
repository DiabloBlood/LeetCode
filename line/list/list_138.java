


class Solution138 {

    /** 
     * Time:  O(3n), copyNext O(n), copyRandom O(n), split O(n)
     * Space: O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return split(head);
    }
    
    private void copyNext(Node head) {
        while (head != null) {
            Node temp = head.next;
            head.next = new Node(head.val);
            head.next.next = temp;
            head = temp;
        }
    }
    
    private void copyRandom(Node head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private Node split(Node head) {
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = null;
        return evenHead;
    }

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node fakeHead = new Node(-1);
        Node cur = fakeHead;
        while (head != null) {
            cur.next = copy(head, map);
            if (head.random != null) {
                cur.next.random = copy(head.random, map);
            }
            head = head.next;
            cur = cur.next;
        }
        return fakeHead.next;
    }
    
    private Node copy(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node temp = new Node(node.val);
        map.put(node, temp);
        return temp;
    }
}
