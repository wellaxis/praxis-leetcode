# [LeetCode][leetcode] task # 141: [Linked List Cycle][task]

Description
-----------

> Given `head`, the head of a linked list,
> determine if the linked list has a cycle in it.
> 
> There is a cycle in a linked list if there is some node in the list
> that can be reached again by continuously following the `next` pointer.
> Internally, `pos` is used to denote the index of the node
> that tail's `next` pointer is connected to.
> **Note that `pos` is not passed as a parameter**.
> 
> Return `true` _if there is a cycle in the linked list_.
> Otherwise, return `false`.

Example
-------

![list.png](image/list.png)

```sh
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list,
    where the tail connects to the 1st node (0-indexed).
```

Solution
--------

| Task | Solution                      |
|:----:|:------------------------------|
| 141  | [Linked List Cycle][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/linked-list-cycle/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h2/p141/option/Practice.java>
