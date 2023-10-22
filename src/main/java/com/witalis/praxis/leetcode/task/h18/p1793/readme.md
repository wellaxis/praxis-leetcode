# [LeetCode][leetcode] task # 1793: [Maximum Score of a Good Subarray][task]

Description
-----------

> You are given an array of integers `nums` **(0-indexed)** and an integer `k`.
> 
> The **score** of a subarray `(i, j)` is defined as `min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1)`.
> A **good** subarray is a subarray where `i <= k <= j`.
> 
> Return _the maximum possible **score** of a **good** subarray_.

Example
-------

```sh
Input: nums = [5,5,4,5,4,1,1,1], k = 0
Output: 20
Explanation: The optimal subarray is (0, 4) with a score of min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20.
```

Solution
--------

| Task | Solution                                     |
|:----:|:---------------------------------------------|
| 1793 | [Maximum Score of a Good Subarray][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/maximum-score-of-a-good-subarray/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h18/p1793/option/Practice.java>
