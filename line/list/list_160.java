


public class Solution160 {
    /*
     * Time: Best:   O(min(m, n))
     *       Worst:  O(m + n)
     * Space: O(1)
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        
        return curA;
    }
}