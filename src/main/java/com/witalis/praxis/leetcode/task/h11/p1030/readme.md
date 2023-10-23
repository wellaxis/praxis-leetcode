# [LeetCode][leetcode] task # 1030: [Matrix Cells in Distance Order][task]

Description
-----------

> You are given four integers `row`, `cols`, `rCenter`, and `cCenter`.
> There is a `rows x cols` matrix, and you are on the cell with the coordinates `(rCenter, cCenter)`.
> 
> Return _the coordinates of all cells in the matrix, sorted by their **distance** from `(rCenter, cCenter)`
> from the smallest distance to the largest distance. You may return the answer in **any order** that satisfies this condition.
> 
> The **distance** between two cells `(r1, c1)` and `(r2, c2)` is `|r1 - r2| + |c1 - c2|`.

Example
-------

```sh
Input: rows = 2, cols = 3, rCenter = 1, cCenter = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (1, 2) to other cells are: [0,1,1,2,2,3]
    There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
```

Solution
--------

| Task | Solution                                   |
|:----:|:-------------------------------------------|
| 1030 | [Matrix Cells in Distance Order][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/matrix-cells-in-distance-order/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1030/option/Practice.java>
