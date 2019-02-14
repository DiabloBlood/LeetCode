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
    /*
    * time complexity: O(n!)
    * 1. every layer of recursive tree, has k! nodes.
    * 2. every node need k/2 times add and k/2 times remove, total is k
    * 3. Finally need copy every leaf node. n*n! times operation.
    * 4. 1! + 2*2! + 3*3! +...+ k*k! +...+ n*n! < 2! + 3! + (k+1)! +...+ n! + (n+1)! < 2(n+1)!, also at(n!) level
    *
    * space complexity: O(n) not include result, stack depth O(n), maintained list O(n) 
    */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        helper(nums, result, new LinkedList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <= depth; i++) {
            list.add(i, nums[depth]);
            helper(nums, result, list, depth + 1);
            list.remove(i);
        }
    }
}