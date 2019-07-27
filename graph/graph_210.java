


class Solution210 {
    /**
     * V = numCourses
     * E = prerequisites.length
     *
     * Time: O(2V + E) ~ O(3V + 2E)
     *     1. O(V + E) of build graph
     *     2. O(V) ~ O(2V + E), O(V) for first find indegree == 0 nodes. If this graph could be topological sort, while loop takes O(V + E).
     *        Best case is no indegree == 0 nodes found, then while loop will escape directly.
     * Space: O(2V + E) ~ O(3V + E)
     *     1. Graph need O(V + E), indegree array need O(V), queue best is O(1) worst is O(V) 
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        //build graph
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: prerequisites) {
            int u = edge[1];
            int v = edge[0];
            graph.get(u).add(v);
            indegree[v]++;
        }
        
        //topological sort
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                result[count++] = i;
            }
        }
        //BFS
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v: graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                    result[count++] = v;
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }
}
