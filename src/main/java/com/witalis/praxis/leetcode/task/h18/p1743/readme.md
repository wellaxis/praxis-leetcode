# [LeetCode][leetcode] task # 1743: [Restore the Array From Adjacent Pairs][task]

Description
-----------

> There is an integer array `nums` that consists of `n` **unique** elements, but you have forgotten it.
> However, you do remember every pair of adjacent elements in `nums`.
> 
> You are given a 2D integer array `adjacentPairs` of size `n - 1` where each `adjacentPairs[i] = [ui, vi]` indicates
> that the elements `ui` and `vi` are adjacent in `nums`.
> 
> It is guaranteed that every adjacent pair of elements `nums[i]` and `nums[i+1]` will exist in `adjacentPairs`,
> either as `[nums[i], nums[i+1]]` or `[nums[i+1], nums[i]]`. The pairs can appear **in any order**.
> 
> Return _the original array `nums`_. If there are multiple solutions, return **any of them**.

Example
-------

```sh
Input: adjacentPairs = [[2,1],[3,4],[3,2]]
Output: [1,2,3,4]
Explanation: This array has all its adjacent pairs in adjacentPairs.
    Notice that adjacentPairs[i] may not be in left-to-right order.
```

Solution
--------

| Task | Solution                                          |
|:----:|:--------------------------------------------------|
| 1743 | [Restore the Array From Adjacent Pairs][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h18/p1743/option/Practice.java>
