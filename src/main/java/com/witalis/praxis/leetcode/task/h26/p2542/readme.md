# [LeetCode][leetcode] task # 2542: [Maximum Subsequence Score][task]

Description
-----------

> You are given two **0-indexed** integer arrays `nums1` and `nums2` of equal length `n` and a positive integer `k`.
> You must choose a **subsequence** of indices from `nums1` of length `k`.
> 
> For chosen indices `i[0]`, `i[1]`, ..., `i[k - 1]`, your score is defined as:
> * The sum of the selected elements from `nums1` multiplied with the **minimum** of the selected elements from `nums2`.
> * It can be defined simply as:
> `(nums1[i[0]] + nums1[i[1]] +...+ nums1[i[k - 1]]) * min(nums2[i[0]] , nums2[i[1]], ... ,nums2[i[k - 1]])`.
>
> Return _the **maximum** possible score_.
> 
> A **subsequence** of indices of an array is a set that can be derived from the set `{0, 1, ..., n-1}`
> by deleting some or no elements.

 Example
-------

```sh
Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
Output: 12
Explanation: 
The four possible subsequence scores are:
- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6. 
- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12. 
- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
Therefore, we return the max score, which is 12.
```

Solution
--------

| Task | Solution                              |
|:----:|:--------------------------------------|
| 2542 | [Maximum Subsequence Score][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/maximum-subsequence-score/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h26/p2542/option/Practice.java>
