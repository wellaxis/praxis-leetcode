# [LeetCode][leetcode] task # 228: [Summary Ranges][task]

Description
-----------

> You are given a **sorted unique** integer array `nums`.
> 
> A **range** `[a,b]` is the set of all integers from `a` to `b` (inclusive).
> 
> Return _the **smallest sorted** list of ranges that
> **cover all the numbers in the array exactly**_.
> That is, each element of `nums` is covered by exactly one of the ranges,
> and there is no integer `x` such that `x` is in one of the ranges but not in `nums`.
> 
> Each range `[a,b]` in the list should be output as:
> * "a->b" if a != b
> * "a" if a == b

Example
-------

```sh
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
    [0,0] --> "0"
    [2,4] --> "2->4"
    [6,6] --> "6"
    [8,9] --> "8->9"
```

Solution
--------

| Task | Solution                   |
|:----:|:---------------------------|
| 228  | [Summary Ranges][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/summary-ranges/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h3/p228/option/Practice.java>
