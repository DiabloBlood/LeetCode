


class Solution {

    private class Node {
        final char label;
        int indegree;
        Set<Node> neighbors;
        Node(char c) {
            label = c;
            neighbors = new HashSet<>();
        }
        
    }
    
    /**
     * Notes:
     * 1. You may assume all letters are in lowercase.
     * 2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
     * 3. If the order is invalid, return an empty string.
     * 4. There may be multiple valid order of letters, return any one of them is fine.
     */
    public String alienOrder(String[] words) {
        if (words == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //build graph
        Node[] graph = new Node[26];
        int dictSize = 0;
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (graph[c - 'a'] == null) {
                    graph[c - 'a'] = new Node(c);
                    dictSize++;
                }
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (graph[c1 - 'a'].neighbors.add(graph[c2 - 'a'])) {
                        graph[c2 - 'a'].indegree++;
                    }
                    break;
                }
            }
        }
        
        // topological sort
        int count = 0;
        Deque<Node> queue = new ArrayDeque<>();
        for (Node u: graph) {
            if (u != null && u.indegree == 0) {
                queue.offer(graph[u.label - 'a']);
                sb.append(u.label);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            Node u = queue.poll();
            for (Node v: graph[u.label - 'a'].neighbors) {
                v.indegree--;
                if (v.indegree == 0) {
                    queue.offer(v);
                    sb.append(v.label);
                    count++;
                }
            }
        }
        return count == dictSize ? sb.toString() : "";
    }
}
