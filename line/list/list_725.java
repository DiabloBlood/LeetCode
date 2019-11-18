


public class Solution725 {
	/**
     * Problem Analysis:
     *     1. Get list size first, use get size code template.
     *     2. Default size of a part is `size / k`.
     *     3. The number of large parts is `size ％　k`;
     *     4. For every part, calculate `thisPartSize` first, then split list to pieces based on `thisPartSize`.
     *     5. Hold a `head` of every part piece, use `head` and `cur` as two pointers to cut out list.
     *
     * Case Analysis:
     *     1. i <  largePartNum; ---> thisPartSize = partSize + 1;
     *     2. i >= largePartNum; ---> thisPartSize = partSize;
     *
     * Corner Cases:
     *     1. root == null; ---> return new ListNode[k]; // all `k` parts is `null`
     *     2. k > list size; ---> check if `cur.next` is `null`, if it is, should break for loop.
     *        // case input `1->2->3->null`, k = 5. This case has `partSize == 0`, several tail parts is `null`.
     *
     * Time:  O(2n), two passes, get list size is `n`, for loop is another `n`.
     * Space: O(1)
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[k];
        }
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        int partSize = size / k;
        int largePartNum = size % k;
        cur = head;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int thisPartSize = i < largePartNum ? partSize + 1 : partSize;
            for (int j = 0; j < thisPartSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            result[i] = head;
            if (next == null) {
                break;
            }
            head = next;
            cur = head;
        }
        return result;
    }
}
