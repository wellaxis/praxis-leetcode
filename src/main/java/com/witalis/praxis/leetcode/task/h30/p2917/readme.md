# [LeetCode][leetcode] task # 2917: [Find the K-or of an Array][task]

Description
-----------

> You are given a **0-indexed** integer array `nums`, and an integer `k`.
> 
> The **K-or** of `nums` is a non-negative integer that satisfies the following:
> * The `i^th` bit is set in the K-or **if and only if** there are at least `k` elements of nums in which bit `i` is set.
>
> Return _the **K-or** of `nums`_.
> 
> **Note** that a bit `i` is set in `x` if `(2^i AND x) == 2^i`, where `AND` is the bitwise `AND` operator.

 Example
-------

```sh
Input: nums = [7,12,9,8,9,15], k = 4
Output: 9
Explanation: Bit 0 is set at nums[0], nums[2], nums[4], and nums[5].
    Bit 1 is set at nums[0], and nums[5].
    Bit 2 is set at nums[0], nums[1], and nums[5].
    Bit 3 is set at nums[1], nums[2], nums[3], nums[4], and nums[5].
    Only bits 0 and 3 are set in at least k elements of the array, and bits i >= 4 are not set in any of the array's elements. Hence, the answer is 2^0 + 2^3 = 9.
```

Solution
--------

| Task | Solution                              |
|:----:|:--------------------------------------|
| 2917 | [Find the K-or of an Array][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/find-the-k-or-of-an-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h30/p2917/option/Practice.java>
