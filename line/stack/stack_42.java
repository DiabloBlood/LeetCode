




class Solution42 {

    /*
     * Case Analysis:
     * 1. mL < mR; 
     *    <1>. h[start] < mL < mR; computable;
     *    <2>. mL < h[start] < mR; computable;
     *    <3>. mL < mR < h[start]; computable;
     *    <4>. h[end] < mL < mR; non-computable;
     *    <5>. mL < h[end] < mR; non-computable;
     *    <6>. mL < mR < h[end]; computable;
     *
     * 2. mL >= mR; 
     *    <1>. h[start] > mL > mR; computable;
     *    <2>. mL > h[start] > mR; non-computable;
     *    <3>. mL > mR > h[start]; non-computable;
     *    <4>. h[end] > mL > mR; computable;
     *    <5>. mL > h[end] > mR; computable;
     *    <6>. mL > mR > h[end]; computable;
     */

    /*
     * Time:  O(n)
     * Space: O(1)
     *
     */

    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        
        int sum = 0;

        while (start <= end) {
            if (maxLeft < maxRight) {
                sum += maxLeft > height[start] ? maxLeft - height[start] : 0;
                maxLeft = Math.max(maxLeft, height[start]);  
                start++;
            } else {
                sum += maxRight > height[end] ? maxRight - height[end] : 0;
                maxRight = Math.max(maxRight, height[end]);
                end--;
            }
        }
        return sum;
    }

    /*
     * Optimization of code in while loop, compute maxLeft and maxRight first is OK.
     */
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int sum = 0;

        while (start <= end) {
            if (maxLeft < maxRight) {
                maxLeft = Math.max(maxLeft, height[start]);
                sum += maxLeft - height[start]; 
                start++;
            } else {
                maxRight = Math.max(maxRight, height[end]);
                sum += maxRight - height[end];
                end--;
            }
        }
        return sum;
    }

    /*
     * Very trivial solution, for every position i, find the left max boundary and the right max boundary.
     * Time:  O(n^2)
     * Space: O(1)
     *
     */
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int minBoundray = Math.min(maxLeft, maxRight);
            sum += minBoundray > height[i] ? minBoundray - height[i] : 0;
        }
        return sum;
    }

    /*
     * Case Analysis:
     * 1. stack.isEmpty(); stack.push(i);
     * 2. !stack.isEmpty() && a[i] <= a[stack.peek()]; stack.push(i);
     * 3. Loop: !stack.isEmpty() && a[i] > a[stack.peek()];
     *          curIndex = stack.pop();
     *          int leftIndex = stack.peek();
     *          int h = min(height[leftIndex], height[i]) - height[curIndex];
     *          sum += (i - leftIndex - 1) * h;
     */
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curIndex = stack.pop();
                if (!stack.isEmpty()) {
                    int leftIndex = stack.peek();
                    int h = Math.min(height[leftIndex], height[i]) - height[curIndex];
                    sum += (i - leftIndex - 1) * h;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}









