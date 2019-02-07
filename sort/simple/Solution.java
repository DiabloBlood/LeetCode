
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


public class Solution {

    //insertion sort
    public void simpleSort(int[] nums) {
        if (nums == null) {
           return; 
        }
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        while (head != null) {
            ListNode cur = fakeHead;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            ListNode temp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = temp;
        }
        return fakeHead.next;
    }


    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = {4, 5, 3, 2, 1};
        ss.simpleSort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        ListNode a = new ListNode(-1);
        System.out.println(a.next);
    }
}