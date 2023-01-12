# [LeetCode][leetcode] task # 1519: [Number of Nodes in the Sub-Tree With the Same Label][task]

Description
-----------

> You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of `n` nodes
> numbered from `0` to `n - 1` and exactly `n - 1` edges. The **root** of the tree is the node `0`,
> and each node of the tree has **a label** which is a lower-case character given in the string `labels`
> (i.e. The node with the number `i` has the label `labels[i]`).
> 
> The `edges` array is given on the form `edges[i] = [ai, bi]`,
> which means there is an edge between nodes `ai` and `bi` in the tree.
> 
> Return _an array of size `n` where `ans[i]` is the number of nodes in the subtree of the `i^th` node 
> which have the same label as node `i`_.
> 
> A subtree of a tree `T` is the tree consisting of a node in `T` and all of its descendant nodes.

Example
-------

![tree.png](image/tree.png)

```sh
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
Output: [2,1,1,1,1,1,1]
Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
    Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).
```

Solution
--------

| Task | Solution                                                        |
|:----:|:----------------------------------------------------------------|
| 1519 | [Number of Nodes in the Sub-Tree With the Same Label][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h16/p1519/option/Practice.java>
