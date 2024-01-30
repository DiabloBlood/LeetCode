


public class Solution278 {
        /**
     * Notes:
     *     1.
     *
     * Problem Analysis:
     *     1. Assume dis(i) = abs(arr[i] - x) if the distance from element arr[i] to point x,
     *        then disSum(i) = dis(i) + dis(i + 1) +...+ dis(i + k), the solution is to find
     *        first occurence of `pos` such that disSum(pos) has smallest value.
     *     2. Use O(n) time algorithm to traverse this array is a trivial solution.
     *
     * General Cases:
     *     1. i <  k - 1; ---> // do nothing
     *     2. i >= k - 1; ---> compare sum and pos, subtract dis(i - k + 1)
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int sum = 0;
        int pos = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i] - x);
            if (i >= k - 1) {
                if (sum < min) {
                    pos = i - k + 1;
                    min = sum;
                }
                sum -= Math.abs(arr[i - k + 1] - x);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = pos; i < start + k; i++) {
            result.add(arr[i]);
        }
        return Arrays.stream(arr, pos, pos + k).boxed().collect(Collectors.toList());
        return result;
    }
}
