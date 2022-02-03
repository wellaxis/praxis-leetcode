# [LeetCode][leetcode] task # 160: [Intersection of Two Linked Lists][task]

Description
-----------

> Given the heads of two singly linked-lists `headA` and `headB`,
> return _the node at which the two lists intersect_.
> If the two linked lists have no intersection at all, return `null`.
> 
> For example, the following two linked lists begin to intersect at node `c1`:

![list.png](image/list.png)

> The test cases are generated such that
> there are no cycles anywhere in the entire linked structure.
> 
> **Note** that the linked lists **must retain their original structure**
> after the function returns.

> **Custom Judge:**
> 
> The inputs to the **judge** are given as follows
> (your program is **not** given these inputs):
> * `intersectVal` - The value of the node where the intersection occurs.
> This is `0` if there is no intersected node.
> * `listA` - The first linked list.
> * `listB` - The second linked list.
> * `skipA` - The number of nodes to skip ahead in `listA`
> (starting from the head) to get to the intersected node.
> * `skipB` - The number of nodes to skip ahead in `listB`
> (starting from the head) to get to the intersected node.

> The judge will then create the linked structure based on these inputs
> and pass the two heads, `headA` and `headB` to your program.
> If you correctly return the intersected node,
> then your solution will be **accepted**.

Example
-------

![sample.png](image/sample.png)

```sh
Input:
    intersectVal = 8,
    listA = [4,1,8,4,5],
    listB = [5,6,1,8,4,5],
    skipA = 2,
    skipB = 3
Output:
    Intersected at '8'
Explanation: The intersected node's value is 8
    (note that this must not be 0 if the two lists intersect).
    From the head of A, it reads as [4,1,8,4,5].
    From the head of B, it reads as [5,6,1,8,4,5].
    There are 2 nodes before the intersected node in A;
    There are 3 nodes before the intersected node in B.
```

Solution
--------

| Task | Solution                                     |
|:----:|:---------------------------------------------|
| 160  | [Intersection of Two Linked Lists][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/intersection-of-two-linked-lists/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p160/option/Practice.java>
