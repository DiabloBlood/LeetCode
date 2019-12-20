


class Solution98 {
    /**
     * Key Points:
     *     1. BST property, all nodes of left subtree < root.val, all nodes of right subtree > root.val,
     *        and this is a recursive definition.
     *     2. Type of `Long.MAX_VALUE` is `long`, `node.val <= min` expression convert `node.val` to `long` type.
     *
     * Problem Analysis:
     *     1. Value range of root should be [-inf, inf], but we don't have real `inf` in java.
     *     2. For the 4 valid input trees as follow, if use `Integer.MIN_VALUE` as `min`
     *        and `Integer.MAX_VALUE` as `max`, the result will be `false`. That's why
     *        use `Long.MAX_VALUE` and `Long.MIN_VALUE`.
     *
     *        2^31 - 1    -2^31    1             1
     *                              \           /
     *                           2^31 - 1    -2^31
     * Base Cases:
     *     1. node == null; ---> return true; // case 1: `null` from a leaf node.
     *                                        // case 2: `null` from a one-child parent node.
     *     2. node.val <= min && node.val <  max; ---> return false;
     *     3. node.val <= min && node.val >= max; ---> // impossible;
     *     4. node.val >  min && node.val >= max; ---> return false;
     *     combine 2, 3, 4
     *     2. node.val <= min || node.val >= max; ---> return false; // breaks BST property.
     *
     * General Cases;
     *     1. node.val >  min && node.val <  max && helper(left) == true  && helper(right) == true;  ---> return true;
     *     2. node.val >  min && node.val <  max && helper(left) == true  && helper(right) == false; ---> return false;
     *     3. node.val >  min && node.val <  max && helper(left) == false && helper(right) == true;  ---> return false;
     *     4. node.val >  min && node.val <  max && helper(left) == false && helper(right) == false; ---> return false;
     *     Since `node.val >  min && node.val < max` already guaranteed, just return `helper(left) && helper(right)` is enough.
     *
     * Time:  best  O(1), could detect not BST very early, tree pruning applied.
     *        worst O(n), the valid BST will be traversed all nodes.
     * Space: best  O(1), if detected not BST very early.
     *        worst O(n), for skewed binary tree (Any shape), and if this tree is a valid BST.
     *        avg   O(logn) for height-balanced binary tree, complete binary tree, full binary tree.
     */
    public boolean isValidBST(TreeNode root) {
        return helper(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    private boolean helper(long min, long max, TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return helper(min, node.val, node.left) && helper(node.val, max, node.right);
    }

    /**
     * Key Points:
     *     1. BST property, all node of left subtree < root.val, all nodes of right subtree > root.val,
     *        and this is a recursive definition.
     *
     * Problem Analysis:
     *     1. Value range of root should be [-inf, inf], but we don't have real `inf` in java.
     *     2. For the 4 valid input trees as follow, if just use `Integer.MIN_VALUE` as `min`
     *        and `Integer.MAX_VALUE` as `max`, the result will be `false`. So we should use `hasMin`
     *        and `hasMax` flag to declare if range [min, max] applies to this node.
     *
     *        2^31 - 1    -2^31    1             1
     *                              \           /
     *                           2^31 - 1    -2^31
     *     3. Range constraints of nodes are as follow,
     *        nodeType                                   range          hasMin    hasMax
     *        root node                                  [-inf, inf]     false     false
     *        left  boundray nodes (only .left  path)    [-inf, max]     false      true
     *        right boundray nodes (only .right path)    [min,  inf]      true     false
     *        other nodes                                [min,  max]      true      true
     *
     * Base Cases:
     *     1. node == null; ---> return true; // case 1: `null` from a leaf node.
     *                                        // case 2: `null` from a one-child parent node.
     *     2. hasMin && node.val <= min || hasMax && node.val >= max; ---> return false; // breaks BST property.
     *
     * General Cases;
     *     Use demorgan's law of base case 2, we could get
     *     !(hasMin && node.val <= min) && !(hasMax && node.val >= max)
     *     => (!hasMin || node.val > min) && (!hasMax || node.val < max)
     *     Since `(!hasMin || node.val > min) && (!hasMax || node.val < max)` already guaranteed,
     *     just return `helper(left) && helper(right)` is enough.
     *
     * Time:  best  O(1), could detect not BST very early, tree pruning applied.
     *        worst O(n), the valid BST will be traversed all nodes.
     * Space: best  O(1), if detected not BST very early.
     *        worst O(n), for skewed binary tree (Any shape), and if this tree is a valid BST.
     *        avg   O(logn) for height-balanced binary tree, complete binary tree, full binary tree.
     */
    public boolean isValidBST(TreeNode root) {
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, false, false, root);
    }

    private boolean helper(int min, int max, boolean hasMin, boolean hasMax, TreeNode node) {
        if (node == null) {
            return true;
        }
        if (hasMin && node.val <= min || hasMax && node.val >= max) {
            return false;
        }
        return helper(min, node.val, hasMin, true, node.left) && helper(node.val, max, true, hasMax, node.right);
    }
}
