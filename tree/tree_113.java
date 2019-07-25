


class Solution113 {
    /**
     * Notes: Don't need to handle `root == null` corner case.
     * 
     * Time:  O(n), the only way to get result is to traverse all the nodes.
     * Space: Worst O(2n), stack O(n), path list O(n), for flat list tree.
     *        Best  O(2*logn), stack O(logn), path list O(logn), for balanced tree 
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), root, sum);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        int nextSum = sum - node.val;
        if (node.left == null && node.right == null && nextSum == 0) {
            result.add(new ArrayList<>(list));
        }
        helper(result, list, node.left, nextSum);
        helper(result, list, node.right, nextSum);
        list.remove(list.size() - 1);
    }
}
