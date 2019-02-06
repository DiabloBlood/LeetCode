


class TreeNode(object):

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


from collections import deque

class Solution(object):

    def levelOrderBottom(self, root):
        if not root:
            return []
        result = []
        queue = deque()
        queue.append(root)
        while len(queue):
            level_total = len(queue)
            sub_list = []
            for i in range(level_total):
                cur = queue.popleft()

                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)

                sub_list.append(cur.val)

            result.append(sub_list)

        result.reverse()
        return result




