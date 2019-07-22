


public class Solution46 {
    /**
     * Tree 1 DFS method. (Overhead is low than BFS method)
     *  
     * Time: O(n^2 * n!)
     *     1. Zero layer has `1` node, 1st layer has `n` nodes, 2nd layer has `n*(n-1)` nodes, 3rd layer has `n*(n-1)*(n-2)` nodes, leaf layer has `n!` nodes.
     *     2. In every layer, the for loop, each node need `(k/2)*k` times comparation, `k` is the length of template list, `n-k` times add and `n-k` times remove.
     *     3. In each layer, total operations of each node is `k^2/2 + 2*(n-k)` < `(n^2/2)`
     *     3. At leaf layer, each node need `n` times copy to result list, total is `n*n!` times operations.
     *     4. Total = n + n(n^2/2) * n*(n-1) + (n^2/2) * n*(n-1)*(n-2) +...+
     *                (n^2/2) * n*(n-1)*(n-2)*...*(n-k) +...+ (n^2/2) * n*(n-1)*(n-2)*...*1 + n*n!
     *              < (n^2/2) * (n-1)! +...+ (n^2/2) * (n-1)! + (n^2/2) * n! + (n^2/2) * n! + n*n!
     *              = 3 * (n^2/2) * n! + n*n!
     *              = O(n^2 * n!)
     *     Notes: n*(n-1)*(n-2)*...*1 is the last 2nd layer operations quantity.
     * Space: O(2n), O(n) of template list, O(n) of stack
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }

    /**
     * Tree 1 BFS method.
     *
     * Time: O(1.5 * n^2 * n!)
     *     1. Zero layer has `1` node, 1st layer has `n` nodes, 2nd layer has `n*(n-1)` nodes, 3rd layer has `n*(n-1)*(n-2)` nodes, leaf layer has `n!` nodes.
     *     2. In every layer, the for loop, each node need `(k/2)*k` times comparation, `k` is the length of template list, `n-k` times add, `(n-k)*k` tims copy.
     *     3. In each layer, total operations of each node is `k^2/2 + (k+1)*(n-k)` < `(n^2/2)`
     *     4. Total = n + n(n^2/2) * n*(n-1) + (n^2/2) * n*(n-1)*(n-2) +...+
     *                (n^2/2) * n*(n-1)*(n-2)*...*(n-k) +...+ (n^2/2) * n*(n-1)*(n-2)*...*1
     *              < (n^2/2) * (n-1)! +...+ (n^2/2) * (n-1)! + (n^2/2) * n! + (n^2/2) * n!
     *              = 3 * (n^2/2) * n!
     *              = O(n^2 * n!)
     *     Notes1: n*(n-1)*(n-2)*...*1 is the last 2nd layer operations quantity.
     *     Notes2: BFS method doesn't has the last layer `n*n!` copy overhead.
     *             However, each node `k^2/2 + (k+1)*(n-k)` times operations is larger than `k^2/2 + 2*(n-k)` of DFS method.
     *     Notes3: For every single element in result list, DFS only copy one time, BFS will copy many times.
     *             So DFS method is better.
     * Space: O(n). result.remove(0) takes O(n), but makes more pressure to GC. No other extra space.
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            // i + 1 is layer
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = result.remove(0);
                for (int k = 0; k < nums.length; k++) {
                    if (temp.contains(nums[k])) {
                        continue;
                    }
                    List<Integer> list = new ArrayList<>(temp);
                    list.add(nums[k]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     * Tree 2 DFS method.
     * 
     * Time: O(n^2 * n!)
     *    1. every layer of recursive tree, has k! nodes.
     *    2. every node has k+1 positions to insert/remove
     *    3. every insert/remove need k/2 times operations
     *    4. every layer to next layer need k^2*k! operations
     * Space: O(2n) not include result, stack depth O(n), template list O(n) 
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        helper(nums, result, new ArrayList<>(), 0);
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

    /**
     * Tree 2 BFS method.
     * 
     * Time: O((n^2 * n!)from k to k + 1, need (k^2)*k! times operations, SIGMA k^2*k! < 2 * (k^2*k!)
     * Space: O(n), the temp list need extra space, but every time when for loop end, GC will collect it.
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = result.remove(0);
                // i == temp.size()
                for (int k = 0; k <= i; k++) {
                    List<Integer> list = new ArrayList<>(temp);
                    list.add(k, nums[i]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
