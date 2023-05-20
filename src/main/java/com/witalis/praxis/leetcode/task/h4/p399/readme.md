# [LeetCode][leetcode] task # 399: [Evaluate Division][task]

Description
-----------

> You are given an array of variable pairs `equations` and an array of real numbers `values`,
> where `equations[i] = [Ai, Bi]` and `values[i]` represent the equation `Ai / Bi = values[i]`.
> Each `Ai` or `Bi` is a string that represents a single variable.
> 
> You are also given some `queries`, where `queries[j] = [Cj, Dj]` represents
> the `j^th` query where you must find the answer for `Cj / Dj = ?`.
> 
> Return _the answers to all queries_. If a single answer cannot be determined, return `-1.0`.
> 
> **Note**: The input is always valid. You may assume that evaluating the queries
> will not result in division by zero and that there is no contradiction.

Example
-------

```sh
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
    Given: a / b = 2.0, b / c = 3.0
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
    return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
```

Solution
--------

| Task | Solution                      |
|:----:|:------------------------------|
| 399  | [Evaluate Division][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/evaluate-division/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h4/p399/option/Practice.java>
