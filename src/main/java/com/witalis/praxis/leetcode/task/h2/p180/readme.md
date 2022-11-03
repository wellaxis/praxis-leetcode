# [LeetCode][leetcode] task # 180: [Consecutive Numbers][task]

Description
-----------

> Table: Logs
```sh
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
```
> id is the primary key for this table.
> id is an autoincrement column.
> 
> Write an SQL query to find all numbers that appear at least three times consecutively.
> 
> Return the result table in **any order**.
> 
> The query result format is in the following example.

Example
-------

```sh
Input: 
Logs table:
+----+-----+
| id | num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
Output: 
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
Explanation: 1 is the only number that appears consecutively for at least three times.
```

Solution
--------

| Task | Solution                        |
|:----:|:--------------------------------|
| 180  | [Consecutive Numbers][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/consecutive-numbers/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h2/p180/option/Practice.java>
