# [LeetCode][leetcode] task # 610: [Triangle Judgement][task]

Description
-----------

> Table: Triangle
```sh
+-------------+------+
| Column Name | Type |
+-------------+------+
| x           | int  |
| y           | int  |
| z           | int  |
+-------------+------+
```
> `(x, y, z)` is the primary key column for this table.
> Each row of this table contains the lengths of three line segments.
>
> Write an SQL query to report for every three line segments whether they can form a triangle.
> 
> Return _the result table in **any order**_.
> 
> The query result format is in the following example.

Example
-------

```sh
Input: 
Triangle table:
+----+----+----+
| x  | y  | z  |
+----+----+----+
| 13 | 15 | 30 |
| 10 | 20 | 15 |
+----+----+----+
Output: 
+----+----+----+----------+
| x  | y  | z  | triangle |
+----+----+----+----------+
| 13 | 15 | 30 | No       |
| 10 | 20 | 15 | Yes      |
+----+----+----+----------+
```

Solution
--------

| Task | Solution                       |
|:----:|:-------------------------------|
| 610  | [Triangle Judgement][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/triangle-judgement/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h7/p610/option/Practice.java>
