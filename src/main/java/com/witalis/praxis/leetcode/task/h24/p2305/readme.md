# [LeetCode][leetcode] task # 2305: [Fair Distribution of Cookies][task]

Description
-----------

> You are given an integer array `cookies`, where `cookies[i]` denotes the number of cookies in the `i^th` bag.
> You are also given an integer `k` that denotes the number of children to distribute **all** the bags of cookies to.
> All the cookies in the same bag must go to the same child and cannot be split up.
> 
> The **unfairness** of a distribution is defined as the **maximum total** cookies obtained by a single child in the distribution.
> 
> Return _the **minimum** unfairness of all distributions_.

 Example
-------

```sh
Input: cookies = [8,15,10,20,8], k = 2
Output: 31
Explanation: One optimal distribution is [8,15,8] and [10,20]
- The 1st child receives [8,15,8] which has a total of 8 + 15 + 8 = 31 cookies.
- The 2nd child receives [10,20] which has a total of 10 + 20 = 30 cookies.
The unfairness of the distribution is max(31,30) = 31.
It can be shown that there is no distribution with an unfairness less than 31.
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 2305 | [Fair Distribution of Cookies][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/fair-distribution-of-cookies/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h24/p2305/option/Practice.java>
