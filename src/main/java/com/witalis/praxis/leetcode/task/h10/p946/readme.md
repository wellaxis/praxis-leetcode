# [LeetCode][leetcode] task # 946: [Validate Stack Sequences][task]

Description
-----------

> Given two integer arrays `pushed` and `popped` each with distinct values,
> return _`true` if this could have been the result of a sequence of push and pop operations
> on an initially empty stack, or `false` otherwise_.

Example
-------

```sh
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
    push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
```

Solution
--------

| Task | Solution                             |
|:----:|:-------------------------------------|
| 946  | [Validate Stack Sequences][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/validate-stack-sequences/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h10/p946/option/Practice.java>
