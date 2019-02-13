/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null) {
            return result;
        }
        result.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tempList = result.remove(0);
                for (int k = 0; k <= i; k++) {
                    List<Integer> list = new LinkedList<>(tempList);
                    list.add(k, nums[i]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}