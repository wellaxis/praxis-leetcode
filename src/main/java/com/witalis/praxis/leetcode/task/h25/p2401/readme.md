# [LeetCode][leetcode] task # 2401: [Longest Nice Subarray][task]

Description
-----------

> You are given an array `nums` consisting of **positive** integers.
> 
> We call a subarray of `nums` **nice** if the bitwise **AND** of every pair of elements
> that are in **different** positions in the subarray is equal to `0`.
> 
> Return _the length of the **longest** nice subarray_.
> 
> A **subarray** is a **contiguous** part of an array.
> 
> **Note** that sub-arrays of length `1` are always considered nice.

 Example
-------

```sh
Input: nums = [1,3,8,48,10]
Output: 3
Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
    - 3 AND 8 = 0.
    - 3 AND 48 = 0.
    - 8 AND 48 = 0.
It can be proven that no longer nice subarray can be obtained, so we return 3.
```

Solution
--------

| Task | Solution                          |
|:----:|:----------------------------------|
| 2401 | [Longest Nice Subarray][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/longest-nice-subarray/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h25/p2401/option/Practice.java>
