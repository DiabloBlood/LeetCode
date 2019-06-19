

/*
* Case Analysis:
* 1. nums[i] == nums[end - 2] && nums[i] == nums[end - 1];	// do nothing;
* 2. nums[i] == nums[end - 2] && nums[i] != nums[end - 1]; 	// impossible
* 3. nums[i] != nums[end - 2] && nums[i] != nums[end - 1];	nums[end++] = nums[i];
* 4. nums[i] != nums[end - 2] && nums[i] == nums[end - 1];  nums[end++] = nums[i];
*/

class Solution80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len < 3) {
            return len;
        }
        int end = 2;
        for (int i = 2; i < len; i++) {
            if (nums[i] != nums[end - 2]) {
                nums[end++] = nums[i];
            }
        }
        return end;
    }
}