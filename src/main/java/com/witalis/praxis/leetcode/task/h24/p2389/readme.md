# [LeetCode][leetcode] task # 2389: [Longest Subsequence With Limited Sum][task]

Description
-----------

> You are given an integer array `nums` of length `n`, and an integer array `queries` of length `m`.
> 
> Return _an array `answer` of length `m` where `answer[i]` is the **maximum** size of a **subsequence**
> that you can take from `nums` such that the **sum** of its elements is less than or equal to `queries[i]`_.
> 
> A **subsequence** is an array that can be derived from another array by deleting some or no elements
> without changing the order of the remaining elements.

 Example
-------

```sh
Input: nums = [4,5,2,1], queries = [3,10,21]
Output: [2,3,4]
Explanation: We answer the queries as follows:
- The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
- The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
```

Solution
--------

| Task | Solution                                         |
|:----:|:-------------------------------------------------|
| 2389 | [Longest Subsequence With Limited Sum][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/longest-subsequence-with-limited-sum/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h24/p2389/option/Practice.java>
