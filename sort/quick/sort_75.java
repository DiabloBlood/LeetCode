

// also could use counting sort

// one-pass O(n)
public class Solution {

    public void sortColors(int[] nums) {
        int leftBound = -1;
        int rightBound = nums.length;
        int i = 0;
        while(i < rightBound) {
            if(nums[i] == 0) {
                leftBound++;
                swap(nums, leftBound, i);
                i++;
            } else if(nums[i] == 1) {
                i++;
            } else {
                rightBound--;
                swap(nums, rightBound, i);
            }
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}