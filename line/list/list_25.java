


class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (true) {
            int count = 0;
            ListNode groupHead = head.next;
            ListNode cur = head;
            while (count < k + 1 && cur != null) {
                cur = cur.next;
                count++;
            }
            if (cur == null && count < k + 1) {
                break;
            }
           head.next = reverse(groupHead, cur);
           groupHead.next = cur;
           head = groupHead;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode cur) {
        ListNode prev = null;
        while (head != cur) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
