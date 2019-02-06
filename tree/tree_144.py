


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        '''
        result = []
        self.helper2(root, result)
        return result
        '''
        if not root:
            return []
        result = []
        stack = []
        stack.append(root)

        while len(stack):
            cur = stack.pop()
            result.append(cur.val)

            if cur.right:
                stack.append(cur.right)
            if cur.left:
                stack.append(cur.left)

        return result


    def helper2(self, node, result):

        if not node:
            return

        result.append(node.val)

        self.helper2(node.left, result)
        self.helper2(node.right, result)