


public class Solution90 {
    /**
     * Time:
     *     Worst: no duplicate elements, O(n*2^n), n * 2^(n-1) elements
     *     Best:  all elements is duplicate, O(n^2)
     * Space: O(1)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int prevSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i > 0 && nums[i] == nums[i-1] ? prevSize : 0;
            int size = result.size();
            for (int j = start; j < size; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
            prevSize = size;
        }
        return result;
    }

    /**
     * Time:
     *     Worst: no duplicate elements, O(n*2^n), n * 2^(n-1) times copy, 2^n list add, 2^n list remove.
     *     Best:  all elements is duplicate, O(n^2), n list add, n list remove
     * Space: O(2n), O(n) for implicit stack, O(n) for template list. No matter how many duplicates.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
