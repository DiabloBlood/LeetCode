


class Solution445 {
    /**
     * Reverse list method. 
     *
     * Problem Analysis:
     *     1. Input: (7->2->4->3) + (5->6->4), Output: 7->8->0->7, Explanation: 7243 + 564 = 7807. l1 and l2 is not eversed.
     *     2. l1 and l2 do not contain any leading zero, except the number 0 itself.
     *     3. Reverse l1 and l2 first, then use `list_2.java` method.
     *     4. Please note that `cur.next` need add node at head, so finally doesn't need to reverse `dummy.next`.
     *
     * Case Analysis:
     *     1. l1 == null && l2 == null && carry == 0; ---> while loop break;
     *     2. l1 != null || l2 != null || carry >  0; ---> while loop continue; (Use demorgan's law)
     *
     * Corner Cases:
     *     1. l1 == null && l2 == null;   ---> doesn't need to handle, return value `reverse(dummy.next)` is `null`
     *     2. l1 and l2 only one is null; ---> doesn't need to handle.
     *
     * Time:  O(3n), two passes for l1 and l2 revese, one pass while loop, `m` and `n` is the length of l1 and l2, respectively.
     * Space: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode head = new ListNode(sum % 10);
            head.next = dummy.next;
            dummy.next = head;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * Follow up: cannot revese list, use extra space.
     *
     * Problem Analysis:
     *     1. Input: (7->2->4->3) + (5->6->4), Output: 7->8->0->7, Explanation: 7243 + 564 = 7807. l1 and l2 is not eversed.
     *     2. l1 and l2 do not contain any leading zero, except the number 0 itself.
     *     3. Use stack store value of l1 and l2, then the LIFO order likes list been revesed.
     *     4. Please note that `cur.next` need add node at head, otherwise finally we need to reverse `dummy.next`.
     *
     * Case Analysis:
     *     1. s1.isEmpty()  && s2.isEmpty()  && carry == 0; ---> while loop break;
     *     2. !s1.isEmpty() || !s2.isEmpty() || carry >  0; ---> while loop continue; (Use demorgan's law)
     *
     * Corner Cases:
     *     1. l1 == null && l2 == null;   ---> doesn't need to handle, return value `rdummy.next` is `null`
     *     2. l1 and l2 only one is null; ---> doesn't need to handle.
     *
     * Time:  O(max(m, n)), exactly one pass, `m` and `n` is the length of l1 and l2, respectively.
     * Space: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        load(s1, l1);
        load(s2, l2);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int val1 = s1.isEmpty() ? 0 : s1.pop();
            int val2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = cur.next;
            cur.next = temp;
        }
        return dummy.next;
    }

    private void load(Deque<Integer> stack, ListNode head) {
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
    }
}
