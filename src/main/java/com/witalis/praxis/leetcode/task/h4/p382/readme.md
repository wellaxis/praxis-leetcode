# [LeetCode][leetcode] task # 382: [Linked List Random Node][task]

Description
-----------

> Given a singly linked list, return _a random node's value from the linked list_.
> Each node must have the **same probability** of being chosen.
> 
> Implement the `Solution` class:
> * `Solution(ListNode head)` Initializes the object with the head of the singly-linked list `head`.
> * `int getRandom()` Chooses a node randomly from the list and returns its value.
> All the nodes of the list should be equally likely to be chosen.

Example
-------

![list.png](image/list.png)

```sh
Input
    ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
    [[[1, 2, 3]], [], [], [], [], []]
Output
    [null, 1, 3, 2, 2, 3]
Explanation
    Solution solution = new Solution([1, 2, 3]);
    solution.getRandom(); // return 1
    solution.getRandom(); // return 3
    solution.getRandom(); // return 2
    solution.getRandom(); // return 2
    solution.getRandom(); // return 3
    // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
```

Solution
--------

| Task | Solution                            |
|:----:|:------------------------------------|
| 382  | [Linked List Random Node][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/linked-list-random-node/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h4/p382/option/Practice.java>
