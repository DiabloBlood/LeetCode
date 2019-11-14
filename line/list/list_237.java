


class Solution237 {
    /**
     * Problem Analysis:
     *     1. Since we cannot get the previous node, the only way is change `node.val`.
     *
     * Corner Cases:
     *     1. node is not tail already guaranteed, so `node.next.next` will not throw `NullPointerException`.
     *
     * Time:  O(1)
     * Space: O(1)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * General remove node problem, input `head` and `node`, please remove the reference of `node`.
     *
     * Corner Cases:
     *     1. node == head; ---> if doesn't use dummy node, this case cannot be handled.
     *     2. node == tail; ---> doesn't need to handle.
     *     3. node == null || head == null; ---> illegal input.
     *     4. node not in list; ---> illegal input
     *
     * Time:  O(n), between `1 ~ n`.
     * Space: O(1)
     */
    public void deleteNode(ListNode head, ListNode node) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        while (cur.next != node) {
            cur = cur.next;
        }
        cur.next = node.next; // or cur.next == cur.next.next
        return dummy.next;
    }
    
}
