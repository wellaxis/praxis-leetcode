# [LeetCode][leetcode] task # 1799: [Maximize Score After N Operations][task]

Description
-----------

> You are given `nums`, an array of positive integers of size `2 * n`. You must perform `n` operations on this array.
> 
> In the `i^th` operation (**1-indexed**), you will:
> * Choose two elements, `x` and `y`.
> * Receive a score of `i * gcd(x, y)`.
> * Remove `x` and `y` from `nums`.
>
> Return _the maximum score you can receive after performing `n` operations_.
> 
> The function `gcd(x, y)` is the greatest common divisor of `x` and `y`.

Example
-------

```sh
Input: nums = [1,2,3,4,5,6]
Output: 14
Explanation: The optimal choice of operations is:
(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
```

Solution
--------

| Task | Solution                                      |
|:----:|:----------------------------------------------|
| 1799 | [Maximize Score After N Operations][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/maximize-score-after-n-operations/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h18/p1799/option/Practice.java>
