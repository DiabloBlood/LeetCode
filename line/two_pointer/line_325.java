


public class Solution325 {
    /**
     * Notes:
     *     1. k <= 0 is possible, no limitation of k
     *     2. Any elements in `nums` array could be 0, positive integer or negtive integer. 
     *
     * Problem Analysis:
     *     1. Define f(j, i) as the largest range sum which `i` is right bound. To find f(j, i) == k,
     *        we doesn't need traverse 0 -> i one by one. Just find the first index `j` such as f(j, i) == k
     *        is enough. To achieve this, record key value pair (sum[i], i) during the for loop, then at
     *        loop round `i`, we could use map.get(sum[i] - k) to find the first index `j`. And if sum[0->i1] == sum[0->i2],
     *        just put the first index `i1` into map, this logic will guarantee that we could ge max sub array length.
     *     2. Please notify why place code `map.put(0, -1)` first, then we don't need to add code `if (sum == k) return i + 1;`
     *        at the beginning of each for loop. Otherwise we cannot check sum[0->i] by sum[i] - sum[-1] logic.
     *     3. if cannot find key `sum - k` from map, use default value `i`, which makes this length is always `0`.
     *
     * General Cases:
     *     1. map.getOrDefault(sum - k, i); ---> // refer Problem Analysis 3
     *     2. map.putIfAbsent(sum, i);      ---> // always record the first `i` such as sum[0->i] == a same sum.
     *
     * Corner Cases:
     *     1. nums == null; ---> return 0; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, return value is `0`.
     *
     * Time:  O(n), just a for loop
     * Space: best O(1), if all the elements is same, likes [1, -1, 1, -1, 1, -1, ..], only sum `1` and `0` will put into map.
     *        avg  O(n)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(i - map.getOrDefault(sum - k, i), max);
            map.putIfAbsent(sum, i);
        }
        return max;
    }

    /**
     * O(n^2) method
     *
     * Problem Analysis:
     *     1. Define f(j, i) as the largest range sum which `i` is right bound. To find f(j, i) == k,
     *        traverse 0 -> i one by one, which means check all sums of sum[0->i], sum[1->i], ... sum[i->i].
     *     2. Please notify `break;` of second for loop, only find the first index `j` such as sum[j->i] == k.
     *
     * Corner Cases:
     *     1. nums == null; ---> return 0; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, return value is `0`.
     *
     * Time:  O(0.5n^2), total = (1 + 2 +...+ n) = 0.5n^2, second for loop may takes `i` times if cannot find `sum == k`.
     * Space: O(1)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int max = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int sum = total;
            for (int j = 0; j <= i; j++) {
                if (sum == k) {
                    max = Math.max(i - j + 1, max);
                    break;
                }
                sum -= nums[j];
            }
        }
        return max;
    }
}
