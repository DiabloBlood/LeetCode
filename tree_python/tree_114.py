


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        self.tail = TreeNode(-1)
        self.helper(root)


    def helper(self, node):
        if not node:
            return

        left = node.left
        right = node.right

        self.tail.right = node
        self.tail.left = None
        self.tail = self.tail.right

        self.helper(left)
        self.helper(right)