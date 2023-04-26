# [LeetCode][leetcode] task # 908: [Smallest Range I][task]

Description
-----------

> You are given an integer array `nums` and an integer `k`.
> 
> In one operation, you can choose any index `i` where `0 <= i < nums.length`
> and change `nums[i]` to `nums[i] + x` where `x` is an integer from the range `[-k, k]`.
> You can apply this operation **at most once** for each index `i`.
> 
> The **score** of `nums` is the difference between the maximum and minimum elements in `nums`.
> 
> Return _the minimum **score** of `nums` after applying the mentioned operation at most once for each index in it_.

Example
-------

```sh
Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
```

Solution
--------

| Task | Solution                     |
|:----:|:-----------------------------|
| 908  | [Smallest Range I][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/smallest-range-i/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h10/p908/option/Practice.java>
