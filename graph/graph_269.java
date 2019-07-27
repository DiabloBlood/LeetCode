


class Solution269 {
    
    private class Node {
        final char label;
        int indegree;
        Set<Node> neighbors;
        Node(char c) {
            label = c;
            neighbors = new HashSet<>();
        }
    }
    
    public String alienOrder(String[] words) {
        if (words == null) {
            return "";
        }
        //build graph
        int dictSize = 0;
        Node[] graph = new Node[26];
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
                if (c1 != c2 && graph[c1 - 'a'].neighbors.add(graph[c2 - 'a'])) {
                    graph[c2 - 'a'].indegree++;
                    break;
                }
            }
        }
        
        // topological sort
        Deque<Node> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Node node: graph) {
            if(node != null && node.indegree == 0) {
                queue.offer(node);
                sb.append(node.label);
                count++;
            }
        }
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node neighbor: cur.neighbors) {
                neighbor.indegree--;
                if(neighbor.indegree == 0) {
                    queue.offer(graph[neighbor.label - 'a']);
                    sb.append(neighbor.label);
                    count++;
                }
            }
        }
        return count == dictSize ? sb.toString() : "";
    }
}


