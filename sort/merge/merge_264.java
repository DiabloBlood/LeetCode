


class Solution264 {

    /**
     * Optimized merge sort method. (Very like leetcode23 `Merge k sort lists`)
     * 
     * Time:  O(n), the for loop.
     * space: O(n)
     */
    public int nthUglyNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[n];
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int num2 = 1, num3 = 1, num5 = 1;
        for (int i = 0; i < n; i++) {
            int min = Math.min(Math.min(num2, num3), num5);
            result[i] = min;
            num2 = num2 == min ? 2 * result[idx2++] : num2;
            num3 = num3 == min ? 3 * result[idx3++] : num3;
            num5 = num5 == min ? 5 * result[idx5++] : num5;
        }
        return result[n - 1];
    }

    /**
     * Heap method.
     * 
     * Time:  O(n*logn), `3n` numbers intert into heap and `n` numbers pop from heap.
     * space: O(n), heap need `2n` ~ `3n` space.
     */
    public int nthUglyNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        Queue<Long> queue = new PriorityQueue<>();
        queue.offer(1l);
        for (int i = 1; i < n; i++) {
            long num = queue.poll();
            while (!queue.isEmpty() && queue.peek() == num) {
                queue.poll();
            }
            queue.offer(num * 2);
            queue.offer(num * 3);
            queue.offer(num * 5);
        }
        return queue.poll().intValue();
    }
    /**
     * General merge sort method.
     */
    public int nthUglyNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[n];
        result[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = result[idx2] * 2;
            int num3 = result[idx3] * 3;
            int num5 = result[idx5] * 5;
            int min = Math.min(Math.min(num2, num3), num5);
            result[i] = min;
            if (min == num2) {
                idx2++;
            }
            if (min == num3) {
                idx3++;
            }
            if (min == num5) {
                idx5++;
            }
        }
        return result[n - 1];
    }

    /**
     * Trivial merge sort method.
     *
     * list2: [1, 1 * 2, 2 * 2, 3 * 2, 4 * 2, 5 * 2, 6 * 2, 8 * 2 ...]
     * list3: [1, 1 * 3, 2 * 3, 3 * 3, 4 * 3, 5 * 3, 6 * 3, 8 * 3 ...]
     * list5: [1, 1 * 5, 2 * 5, 3 * 5, 4 * 5, 5 * 5, 6 * 5, 8 * 5 ...]
     *
     * list2: [1, 2, 4,  6,  8,  10, 12, 16]
     * list3: [1, 3, 6,  9,  12, 15, 18, 24]
     * list5: [1, 5, 10, 15, 20, 25, 30, 40]
     * 
     * Case Analysis:
     *     Merge sort list2, list3, list5.
     * 
     */
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        list2.add(1);
        list3.add(1);
        list5.add(1);
        int index2 = 1, index3 = 1, index5 = 1;
        for (int i = 1; i < n; i++) {
            list2.add(result[i - 1] * 2);
            list3.add(result[i - 1] * 3);
            list5.add(result[i - 1] * 5);
            
            int min = Math.min(Math.min(list2.get(index2), list3.get(index3)), list5.get(index5));
            result[i] = min;
            if (min == list2.get(index2)) {
                index2++;
            }
            if (min == list3.get(index3)) {
                index3++;
            }
            if (min == list5.get(index5)) {
                index5++;
            }
        }
        return result[n - 1];
    }
}
