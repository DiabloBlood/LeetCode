


class Solution299 {
    /**
     * Notes:
     *     1. You may assume that the secret number and your friend's guess only contain digits.
     *     2. And their lengths are always equal.
     *
     * Problem Analysis:
     *     1. Likes input secret = "1807", guess = "7810", the key point is how to find cows.
     *
     * General Cases:
     *     1. s == g; ---> bulls++;
     *     2. s != g && map[s] < 0;  ---> cows++; map[s]++; map[g]--; // which means string `guess` meet num `s` before.
     *     3. s != g && map[g] > 0;  ---> cows++; map[s]++; map[g]--; // which means string `secret` meet num 'g' before.
     *     4. s != g && map[s] >= 0; ---> map[s]++; map[g]--;
     *     5. s != g && map[g] >= 0; ---> map[s]++; map[g]--;
     *
     * Corner Cases:
     *     1. secret == null || guess == null || secret.length() != guess.length(); --->
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) {
            throw new IllegalArgumentException();
        }
        int[] map = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
                continue;
            }
            if (map[s] < 0) {
                cows++;
            }
            if (map[g] > 0) {
                cows++;
            }
            map[s]++;
            map[g]--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append('A').append(cows).append('B');
        return sb.toString();
    }

    /**
     * If string `secret` and `guess` not just contains numbers, but also contains letters or other ASCII chars.
     */
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) {
            throw new IllegalArgumentException();
        }
        int[] map = new int[128];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bulls++;
                continue;
            }
            if (map[c1] < 0) {
                cows++;
            }
            if (map[c2] > 0) {
                cows++;
            }
            map[c1]++;
            map[c2]--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append('A').append(cows).append('B');
        return sb.toString();
    }
}
