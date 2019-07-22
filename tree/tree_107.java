


class Solution107 {
    /**
     * BFS method:
     * Time:  O(n)
     * Space: best O(1) of flat list tree, worst O(n/2) of complete binary tree
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }

    /**
     * DFS method:
     * Time:  best O(n + logn), worst O(2n)
     * Space: best O(logN) of complete binary tree, worst O(n) of flat list tree
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Collections.reverse(result);
        return result;
    }
    
    private void helper(List<List<Integer>> result, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        
        result.get(depth).add(node.val);
        helper(result, node.left, depth + 1);
        helper(result, node.right, depth + 1);
    }
}
