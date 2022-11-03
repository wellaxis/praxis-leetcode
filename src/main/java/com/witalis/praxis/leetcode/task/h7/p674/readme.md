# [LeetCode][leetcode] task # 674: [Longest Continuous Increasing Subsequence][task]

Description
-----------

> Given an unsorted array of integers `nums`,
> return _the length of the longest **continuous increasing subsequence** (i.e. subarray)_.
> The subsequence must be **strictly** increasing.
> 
> A **continuous increasing subsequence** is defined by two indices `l` and `r` (`l < r`)
> such that it is `[nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]`
> and for each `l <= i < r`, `nums[i] < nums[i + 1]`.

 Example
-------

```sh
Input: nums = [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
    Even though [1,3,5,7] is an increasing subsequence, it is not continuous
    as elements 5 and 7 are separated by element 4.
```

Solution
--------

| Task | Solution                                              |
|:----:|:------------------------------------------------------|
| 674  | [Longest Continuous Increasing Subsequence][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/longest-continuous-increasing-subsequence/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h7/p674/option/Practice.java>
