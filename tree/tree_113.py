


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        result = []
        self.helper(root, sum, 0, [], result)
        return result


    def helper(self, node, sum, path_sum, path_list, result):

        if not node:
            return

        path_list.append(node.val)

        # leaf node
        if not node.left and not node.right and path_sum + node.val == sum:
            result.append([val for val in path_list])

        self.helper(node.left, sum, path_sum + node.val, path_list, result)
        self.helper(node.right, sum, path_sum + node.val, path_list, result)

        path_list.pop()


        