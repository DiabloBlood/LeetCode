


public class Solution142 {
    /*
     * Proof:
     *     1. Please see list_141.java to see the proof that why `slow` and `fast` will finally meet at same point.
     *     2. Assume `H` is the part not in the circle, `X` is the circle.
     *     3. After `slow` and `fast` meet, meet node is `M`, assume entry point is `E`.
     *     4. The way of `slow`, f(slow) = `H + EM`.
     *     5. The way of `fast`, f(fast) = `H + n*X + EM`.
     *     6. => 2H + 2EM = H + n*X + EM
     *        => H = n*X - EM
     *        => H = (n - 1)*X + ME
     *     7. Which means `head` and `slow` will meet at `E`.
     * 
     * Time:  O(n), from list_141.java, check circle takes `H + k` which between [H, H + 2X], find entry takes 'H'
     *              so total is [2H, 2H + 2X] ~ [2H, 2n] ~ [1, 2n]
     * Space: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return getEntry(slow, head);
            }
        }
        return null;
    }
    
    private ListNode getEntry(ListNode slow, ListNode head) {
        while (slow != head) {
            slow = slow.next;
            head =  head.next;
        }
        return slow;
    }
}
