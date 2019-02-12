/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
import java.util.ArrayList;
import java.util.List;


public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), result, 0);
        return result;
    }

    // dfs method
    // Time complexity: O(n*2^n-1) is worst (no duplicate), O(n^2) is best (all input numbers is same)
    // Space: O(n) Stack is always O(n), no matter all is same or duplicate. List is same, too.
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}