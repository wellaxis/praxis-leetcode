# [LeetCode][leetcode] task # 1802: [Maximum Value at a Given Index in a Bounded Array][task]

Description
-----------

> You are given three positive integers: `n`, `index`, and `maxSum`.
> You want to construct an array `nums` (**0-indexed**) that satisfies the following conditions:
> * `nums.length == n`
> * `nums[i]` is a **positive** integer where `0 <= i < n`.
> * `abs(nums[i] - nums[i+1]) <= 1` where `0 <= i < n-1`.
> * The sum of all the elements of `nums` does not exceed `maxSum`.
> * `nums[index]` is **maximized**.
> 
> Return _`nums[index]` of the constructed array_.
> 
> Note that `abs(x)` equals `x` if `x >= 0`, and `-x` otherwise.

 Example
-------

```sh
Input: n = 4, index = 2,  maxSum = 6
Output: 2
Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
    There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
```

Solution
--------

| Task | Solution                                                      |
|:----:|:--------------------------------------------------------------|
| 1802 | [Maximum Value at a Given Index in a Bounded Array][solution] |

[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h19/p1802/option/Practice.java>