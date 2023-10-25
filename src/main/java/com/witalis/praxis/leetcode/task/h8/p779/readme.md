# [LeetCode][leetcode] task # 779: [K-th Symbol in Grammar][task]

Description
-----------

> We build a table of `n` rows **(1-indexed)**. We start by writing `0` in the `1st` row.
> Now in every subsequent row, we look at the previous row and replace
> each occurrence of `0` with `01`, and each occurrence of `1` with `10`.
> 
> * For example, for `n = 3`, the `1st` row is `0`, the `2nd` row is `01`, and the `3rd` row is `0110`.
> 
> Given two integer `n` and `k`, return _the `k^th` **(1-indexed)** symbol in the `n^th` row of a table of `n` rows.

Example
-------

```sh
Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01
        -
```

Solution
--------

| Task | Solution                           |
|:----:|:-----------------------------------|
| 779  | [K-th Symbol in Grammar][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/k-th-symbol-in-grammar/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h8/p779/option/Practice.java>
