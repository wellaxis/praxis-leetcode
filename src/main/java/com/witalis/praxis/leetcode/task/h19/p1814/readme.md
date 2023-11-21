# [LeetCode][leetcode] task # 1814: [Count Nice Pairs in an Array][task]

Description
-----------

> You are given an array `nums` that consists of non-negative integers.
> Let us define `rev(x)` as the reverse of the non-negative integer `x`.
> For example, `rev(123) = 321`, and `rev(120) = 21`.
> A pair of indices `(i, j)` is **nice** if it satisfies all the following conditions:
> * `0 <= i < j < nums.length`
> * `nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])`
>
> Return _the number of nice pairs of indices_.
> Since that number can be too large, return it **modulo** `10^9 + 7`.

 Example
-------

```sh
Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 1814 | [Count Nice Pairs in an Array][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/count-nice-pairs-in-an-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h19/p1814/option/Practice.java>
