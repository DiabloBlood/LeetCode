


class Solution313 {
    /*
     * Heap Method.
     *  
     * Analysis:
     *    1. This is a merge k sorted lists problem.
     *
     * Time:  O((n+k)*logk), first for loop `k*logk`, second for loop `n*logk`, total while loop operations still at `n` level
     * Space: O(n + k), result array and heap size.
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 1 || primes == null) {
            throw new IllegalArgumentException();
        }
        
        int[] result = new int[n];
        Queue<Num> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Num(1, 0, primes[i]));
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = pq.peek().val;
            // No need to check pq.isEmpty() since every poll will followed by an offer.
            while (pq.peek().val == result[i]) {
                Num num = pq.poll();
                pq.offer(new Num(result[num.idx] * num.prime, num.idx + 1, num.prime));
            }
        }
        return result[n - 1];
    }
    
    private class Num implements Comparable<Num> {
        int val;
        int idx;
        int prime;
        
        Num(int v, int i, int p) {
            val = v;
            idx = i;
            prime = p;
        }
        
        @Override
        public int compareTo(Num that) {
            return this.val - that.val;
        }
    }

    /**
     * Merge Sort Method.
     * 
     * Time:  O(2k*n), Arrays.fill O(k), for loop O(2k*n)
     * Space: O(n + 2k)
     */

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 1 || primes == null) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[n];
        int k = primes.length;
        int[] idx = new int[k];
        int[] val = new int[k];
        Arrays.fill(val, 1);
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                result[i] = Math.min(result[i], val[j]);
            }
            for (int j = 0; j < k; j++) {
                val[j] = val[j] == result[i] ? primes[j] * result[idx[j]++] : val[j];
            }
        }
        return result[n - 1];
    }
}
