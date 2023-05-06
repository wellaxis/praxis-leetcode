# [LeetCode][leetcode] task # 1498: [Number of Subsequences That Satisfy the Given Sum Condition][task]

Description
-----------

> You are given an array of integers `nums` and an integer `target`.
> 
> Return _the number of **non-empty** subsequences of `nums` such that
> the sum of the minimum and maximum element on it is less or equal to `target`_.
> Since the answer may be too large, return it **modulo** `10^9 + 7`.

Example
-------

```sh
Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
    [3] -> Min value + max value <= target (3 + 3 <= 9)
    [3,5] -> (3 + 5 <= 9)
    [3,5,6] -> (3 + 6 <= 9)
    [3,6] -> (3 + 6 <= 9)
```

Solution
--------

| Task | Solution                                                                |
|:----:|:------------------------------------------------------------------------|
| 1498 | [Number of Subsequences That Satisfy the Given Sum Condition][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h15/p1498/option/Practice.java>
