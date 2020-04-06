


public class Solution204 {
    /**
     * Sieve of Eratosthenes method.
     *
     * Notes:
     *     1. Less than `n`, not less or equal than `n`.
     *     2. A prime number (or a prime) is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers.
     *     3. `1` is not a prime.
     *
     * Problem Analysis:
     *     1. Use an array map to mark composite and prime.
     *     2. Use sieve of rratosthenes method.
     *     3. Composite number may marked many times, like `3 * 10`, `5 * 6`.
     *
     * Initialization:
     *     1. i * i < n; ---> // try divisors <= sqrt(n - 1) is enough, please refer method 3.
     *     2. j = i; ---> // `j` from `i` is enough, otherwise will mark likes `2 * 4` and `4 * 2` two times.
     *
     * Corner Cases:
     *     1. n <= 2; ---> return 0;
     *
     * Time:  O(nloglog(sqrt(n))) ~ O(n), 1nd for loop at most: n/2 + n/3 + n/5 + n/7 + ... + n/k - (2 + 3 + 5 + 7 + ... + k),
     *                                    it's a prime reciprocal sum and minus a prime sum, these two sum sequences has `sqrt(n)` items,
     *                                    respectively. This sequence equal to `nloglog(sqrt(n)) - n`, which is a little bit higher than
     *                                    O(n) and much less than O(nlogn). 2nd for loop takes `n`.
     * Space: O(n), array map takes `n`.
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] comp = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!comp[i]) {
                for (int j = i; j * i < n; j++) {
                    comp[j * i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!comp[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Notes:
     *     1. Less than `n`, not less or equal than `n`.
     *
     * Problem Analysis:
     *     1. Check every number use general isPrime method.
     *
     * Corner Cases:
     *     1. n <= 2; ---> return 0;
     *
     * Time:  O(n^1.5), sqrt(2) + sqrt(3) + ... + sqrt(k) + .... + sqrt(n) = integral(sqrt(n)) = O(n^1.5)
     * Space: O(1)
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * How to check if a number is a prime?
     *
     * Problem Analysis:
     *     1. If `n` is a composite number, must have two divisors such that d1 <= sqrt(n) <= d2,
     *        so we can use `i <= sqrt(n)` as for loop condition.
     *     2. Assume x = (int)sqrt(n), then when x^2 < n < (x+1)^2, we still use `i <= x` as condition
     *        instead of `i <= x + 1`, this is becasue if `n` has a divior `x + 1`, then another divisor
     *        must < x + 1, or must be `x`, so use `i <= x` as condition is enough to guarantee find divisors.
     *
     * General Cases:
     *     1. n % i == 0; ---> return false; // which means `n` is a composite number.
     *     2. n % i != 0; ---> // do nothing, not enougth to prove `n` is prime.
     *
     * Corner Cases:
     *     1. n < 2; ---> return false;
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int sqrt = (int)Math.sqrt(n)
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
