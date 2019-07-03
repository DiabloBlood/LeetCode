


class Solution2 {
    /**
     * Time: O(max(m, n))
     * Space: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * Don't need to handle if l1 == null or l2 == null
         */
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            cur.next = new ListNode(sum % 10);
            
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
            carry = sum / 10;
        }
        
        ListNode temp = l1 == null ? l2 : l1;
        
        while (temp != null) {
            int sum = temp.val + carry;
            cur.next = new ListNode(sum % 10);
            
            temp = temp.next;
            cur = cur.next;
            carry = sum / 10;
        }
        
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        
        return fakeHead.next;
    }

    /**
     * Optimization: while loop stop condition is l1 == null && l2 == null && carry == 0,
     *               use De Morgan's law, while loop execute condition is
     *               !(l1 == null && l2 == null && carry == 0)
     *               which equals to l1 != null || l2 != null || carry != 0
     */
    /**
     * Time: O(max(m, n))
     * Space: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            cur.next = new ListNode(sum % 10);
            
            cur = cur.next;
            carry = sum / 10;
            
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        return fakeHead.next;
    }
}




