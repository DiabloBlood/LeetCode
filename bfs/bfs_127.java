


class Solution127 {
    /**
     * Assume word avg length is `m`, wordList length is `n`.
     * Time:  O(25m*n), graph has `n` nodes, every node need check `25 * m` edges.
     * Space: O(n), queue worst size is the most nodes in certain level, `1 ~ n`
     *              set size is `n`
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);
        /**
         * A small optimization.
         */
        if (!set.contains(endWord)) {
            return 0;
        }
        
        int depth = 1;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] cur = queue.poll().toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char temp = cur[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == temp) {
                            continue;
                        }
                        cur[j] = c;
                        String node = new String(cur);
                        if (set.contains(node)) {
                            if (node.equals(endWord)) {
                                return depth + 1;
                            }
                            queue.offer(node);
                            set.remove(node);
                        }
                    }
                    cur[j] = temp;
                }
            }
            depth++;
        }
        return 0;
    }
}
