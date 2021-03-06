## Full Binary Tree vs. Complete Binary Tree
> https://web.cecs.pdx.edu/~sheard/course/Cs163/Doc/FullvsComplete.html
- A **full binary tree** (sometimes proper binary tree or 2-tree) is a tree in which every node other than the leaves has two children.
- A **complete binary tree** is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

## Tree Depth vs. Tree Height
> https://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height
- The **depth** of a node is the number of edges from the node to the tree's root node. A root node will have a depth of 0.
- The **height** of a node is the number of edges on the longest path from the node to a leaf. A leaf node will have a height of 0.
- The **height** of a tree would be the height of its root node, or equivalently, the depth of its deepest node.

A height-balanced binary tree is defined as: a binary tree in which the left and right subtrees of `every node` differ in height by no more than 1.

A skewed binary tree is a type of binary tree in which all the nodes have only either one child or no child. (Maybe left skewed, right skewed or zigzag shape)

The `base case` returns a value without making any subsequent recursive calls. It does this for one or more special input values for which the function can be evaluated without recursion.

Pruning Optimization. (BackTracking)
https://stackoverflow.com/questions/1294720/whats-the-difference-between-backtracking-and-depth-first-search
https://stackoverflow.com/questions/2709030/explain-bfs-and-dfs-in-terms-of-backtracking?noredirect=1&lq=1

Traversal
    - pre-order, in-order, post-order
        - 144, 94, 145, 426, 114, 230
    - level order, BFS vs. DFS
        - 102, 107, 103, 637, 199, 116, 117
    - re-build from pre-order, in-order, post-order
        - 105, 106, 108, 109
Basic Properties of Tree
    - depth
        - 104, 111
    - height
        - 104, 110, 366, 111
    - path
        - 112, 113, 129, 404, 257, 199
    - geometric
        - 100, 101, 226, 236, 235
    - tree list
        - 116, 117, 156, 426, 114
BST
    - 98, 700, 270, 230, 235
BFS shortest path
    - 111
By data structures
    - Map
        - 105, 106
    - stack, sliding window
        - 654, 1008, 255


Finished:
    - 144, 94, 145, 100, 104, 102, 107, 103, 637, 111
    - 112, 105, 106, 108, 109, 116, 117, 156, 199, 101
    - 226, 98, 700, 270, 257, 129, 404, 426, 366, 113
    - 236, 235, 114

Pending:
// 124, 222, 230, 250, 255, 1130-dp
// 654, 669
// 95, 96(dp), 1008
