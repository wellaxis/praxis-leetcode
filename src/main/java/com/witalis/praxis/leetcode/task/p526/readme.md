# [LeetCode][leetcode] task # 526: [Beautiful Arrangement][task]

Description
-----------

> Suppose you have n integers labeled 1 through n.
> A permutation of those n integers perm (1-indexed)
> is considered a beautiful arrangement
> if for every i (1 <= i <= n), either of the following is true:
>
> * perm[i] is divisible by i.
> * i is divisible by perm[i].
>
> Given an integer n, return the number of the beautiful arrangements
> that you can construct.

 Example
-------

```sh
Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
```

Solution
--------

| Task | Solution |
| :------: | :------ |
| 526 | [Beautiful Arrangement][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/beautiful-arrangement/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/p526/option/Practice.java>
