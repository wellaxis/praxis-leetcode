# [LeetCode][leetcode] task # 197: [Rising Temperature][task]

Description
-----------

> Table: Weather
```sh
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
```
> id is the primary key for this table.
> This table contains information about the temperature on a certain day.
>
> Write an SQL query to find all dates' `Id`
> with higher temperatures compared to its previous dates (yesterday).
>
> Return the result table in **any order**.
>
> The query result format is in the following example.

Example
-------

```sh
Input: 
Weather table:
+----+------------+-------------+
| id | recordDate | temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
Output: 
+----+
| id |
+----+
| 2  |
| 4  |
+----+
Explanation:
In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
In 2015-01-04, the temperature was higher than the previous day (20 -> 30).
```

Solution
--------

| Task | Solution                       |
|:----:|:-------------------------------|
| 197  | [Rising Temperature][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/rising-temperature/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p197/option/Practice.java>
