


public class Solution75 {

    /**
     * Notes: Also could use two-pass counting sort 
     *
     * Times: O(n), one-pass
     * Space: O(1)
     */
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        int i = low;
        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, low++, i++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, high--, i);
            }
        }
    }
    
    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}