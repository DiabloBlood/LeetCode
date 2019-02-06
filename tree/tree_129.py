


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.helper(root, 0)


    def helper(self, node, path_sum):

        if not node:
            return 0

        cur_sum = path_sum * 10 + node.val

        if not node.left and not node.right:
            return cur_sum

        return self.helper(node.left, cur_sum) + self.helper(node.right, cur_sum)



    def helper2(self, node, path_sum):

        if not node:
            return

        cur_sum = path_sum + node.val

        # leaf
        if not node.left and not node.right:
            self.result += cur_sum

        self.helper(node.left, cur_sum * 10)
        self.helper(node.right, cur_sum * 10)
        