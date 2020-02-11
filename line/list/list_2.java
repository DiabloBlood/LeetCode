


class Solution2 {
    /**
     * Problem Analysis:
     *     1. Input: (2->4->3->8) + (5->6->4), Output: 7->0->8->, Explanation: 8342 + 465 = 8807. l1 and l2 is reversed.
     *     2. l1 and l2 do not contain any leading zero, except the number 0 itself.
     *
     * Case Analysis:
     *     1. l1 != null && l2 != null && carry >  0; ---> continue
     *     2. l1 != null && l2 != null && carry == 0; ---> continue
     *     3. l1 != null && l2 == null && carry >  0; ---> continue
     *     4. l1 != null && l2 == null && carry == 0; ---> continue
     *     5. l1 == null && l2 != null && carry >  0; ---> continue
     *     6. l1 == null && l2 != null && carry == 0; ---> continue
     *     7. l1 == null && l2 == null && carry >  0; ---> continue
     *     8. l1 == null && l2 == null && carry == 0; ---> break
     *     combine these 8 cases:
     *     1. l1 != null || l2 != null || carry >  0; ---> while loop continue. (Combine cases 1-7 or use demorgan's law of case 8)
     *     2. l1 == null && l2 == null && carry == 0; ---> while loop break.
     *
     * Corner Cases:
     *     1. l1 == null && l2 == null;   ---> doesn't need to handle, return value `dummy.next` is `null`
     *     2. l1 and l2 only one is null; ---> doesn't need to handle.
     *
     * Time:  O(max(m, n)), exactly one pass, `m` and `n` is the length of l1 and l2, respectively.
     * Space: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
