


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque

class Solution(object):

    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        result = []
        queue = deque()
        queue.append(root)

        is_reverse = False

        while len(queue):
            level_num = len(queue)
            sublist = []
            for i in range(level_num):
                cur = queue.popleft()
                sublist.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)

            if is_reverse:
                sublist.reverse()
            is_reverse = not is_reverse

            result.append(sublist)

        return result


        