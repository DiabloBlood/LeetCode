


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


"""
1. The left and right subtrees' heights differ by at most one, AND
2. The left subtree is balanced, AND
3. The right subtree is balanced
"""
class Solution(object):

    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        height, result = self.helper(root)
        return result


    def helper(self, node):
        # None is balanced and height is 0
        if not node:
            return 0, True

        left_height, left_result = self.helper(node.left)
        right_height, right_result = self.helper(node.right)

        height = 1 + max(left_height, right_height)
        result = abs(left_height - right_height) <= 1 and left_result and right_result

        return height, result