


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        return self.helper(root, 0, sum)


    def helper(self, node, path_sum, sum):

        if not node:
            return False

        # node is a leaf
        if not node.left and not node.right:
            return path_sum + node.val == sum

        return self.helper(node.left, path_sum + node.val, sum) or self.helper(node.right, path_sum + node.val, sum)