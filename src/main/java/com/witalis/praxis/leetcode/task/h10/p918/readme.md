# [LeetCode][leetcode] task # 918: [Maximum Sum Circular Subarray][task]

Description
-----------

> Given a **circular integer array** `nums` of length `n`,
> return _the maximum possible sum of a non-empty **subarray** of `nums`_.
> 
> A **circular array** means the end of the array connects to the beginning of the array.
> Formally, the next element of `nums[i]` is `nums[(i + 1) % n]`
> and the previous element of `nums[i]` is `nums[(i - 1 + n) % n]`.
> 
> A **subarray** may only include each element of the fixed buffer `nums` at most once.
> Formally, for a subarray `nums[i], nums[i + 1], ..., nums[j]`,
> there does not exist `i <= k1`, `k2 <= j` with `k1 % n == k2 % n`.

Example
-------

```sh
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
```

Solution
--------

| Task | Solution                                  |
|:----:|:------------------------------------------|
| 918  | [Maximum Sum Circular Subarray][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/maximum-sum-circular-subarray/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h10/p918/option/Practice.java>
