


class Solution250 {
    private class Result {
        boolean isNull;
        boolean isUni;
        int uniVal;
        int count;
        Result(boolean _isNull, boolean _isUni, int _uniVal, int _count) {
          isNull = _isNull;
          isUni = _isUni;
          uniVal = _uniVal;
          count = _count;
        }
    }

    public int countUnivalSubtrees(TreeNode root) {
        return helper(root).count;
    }
    /**
     * General Cases:
     *     outer cases:
     *         1. leftRes.isUni && rightRes.isUni;
     *     inner cases:
     *         1. leftRes.isNull && rightRes.isNull;              ---> true;
     *         2. leftRes.isNull && rightRes.uniVal == node.val;  ---> true;
     *         3. rightRes.isNull && leftRes.uniVal == node.val;  ---> true;
     *         4. !leftRes.isNull && !rightRes.isNull && sameVal; ---> true;
     */
    private Result helper(TreeNode node) {
        if (node == null) {
            return new Result(true, true, -1, 0);
        }
        Result leftRes = helper(node.left);
        Result rightRes = helper(node.right);
        boolean isUni = false;
        int count = leftRes.count + rightRes.count;
        if (leftRes.isUni && rightRes.isUni) {
            if (leftRes.isNull && rightRes.isNull || leftRes.isNull || rightRes.isNull || leftRes.uniVal == rightRes.uniVal && leftRes.uniVal == node.val) {
                isUni = true;
                count++;
            }
        }
        return new Result(false, isUni, node.val, count);
    }

        private class Result {
      TreeNode lca;
      boolean isExist;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    }
    /**
     * General Cases:
     *     1. !left.isExist && !right.isExist; ---> lca = null; isExist = false; // lca = right.lca could helper merge cases
     *                                                                              since right.lca is null;
     *     2. !left.isExist && right.isExist;  ---> lca = right.lca; isExist = true;
     *     3. left.isExist && !right.isExist;  ---> lca = left.lca; isExist = true;
     *     $. left.isExist && right.isExist;   ---> lca = node; isExist = true;
     */
    private Result helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new Result(null, false);
        }
        if (node == p || node == q) {
            return new Result(node, true);
        }
        Result left = new helper(node.left, p, q);
        Result right = new helper(node.right, p, q);
        TreeNode lca = null;
        boolean isExist = false;
        
    }
}
