


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

// O(n^2 / 4)
public class Solution147 {
    // any time there are two Lists
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode cur;
        while(head != null) {
            cur = fakeHead;
            while(cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            ListNode tmp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = tmp;
        }
        return fakeHead.next;
    }
}