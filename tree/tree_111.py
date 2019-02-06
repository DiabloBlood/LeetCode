


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        left_depth = self.minDepth(root.left)
        right_depth = self.minDepth(root.right)

        """
        left = 0, right = 0, 1
        left > 0, right = 0, left + 1
        left = 0, right > 0, right + 1
        left > 0, right > 0, min(left, right)
        """

        result = (left_depth + right_depth + 1) if left_depth == 0 or right_depth == 0 else 1 + min(left_depth, right_depth)

        return result