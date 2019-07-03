


class Solution86 {
    /**
     * Case Analysis:
     *      After loop end, one of left.next and right.next is not null. It depends on if tail.val < x or >= x.
     * Time:  O(n)
     * Space: O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}