


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


public class Solution21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			//throw new IllegalArgumentException();
			return null;
		}
		
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		cur.next = l1;
        		l1 = l1.next;
        	} else {
        		cur.next = l2;
        		l2 = l2.next;
        	}
        	cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return fakeHead.next;
    }
}
