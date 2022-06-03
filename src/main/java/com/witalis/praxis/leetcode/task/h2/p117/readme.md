# [LeetCode][leetcode] task # 117: [Populating Next Right Pointers in Each Node II][task]

Description
-----------

> Given a binary tree

```sh
struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
}
```
> Populate each next pointer to point to its next right node.
> If there is no next right node, the next pointer should be set to `NULL`.
> 
> Initially, all next pointers are set to `NULL`.

 Example
-------

![node.png](image/node.png)

```sh
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A),
    your function should populate each next pointer to point to its next right node, just like in Figure B.
    The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
```

Solution
--------

| Task | Solution                                                   |
|:----:|:-----------------------------------------------------------|
| 117  | [Populating Next Right Pointers in Each Node II][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p117/option/Practice.java>
