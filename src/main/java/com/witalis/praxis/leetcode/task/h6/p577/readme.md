# [LeetCode][leetcode] task # 577: [Employee Bonus][task]

Description
-----------

> Table: Employee
```sh
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| empId       | int     |
| name        | varchar |
| supervisor  | int     |
| salary      | int     |
+-------------+---------+
```
> `empId` is the primary key column for this table.
> Each row of this table indicates the `name` and the `ID` of an employee
> in addition to their `salary` and the `id` of their manager.
>
> Table: Bonus
```sh
+-------------+------+
| Column Name | Type |
+-------------+------+
| empId       | int  |
| bonus       | int  |
+-------------+------+
```
> `empId` is the primary key column for this table.
> `empId` is a foreign key to `empId` from the Employee table.
> Each row of this table contains the `id` of an employee and their respective `bonus`.
>
> Write an SQL query to report the name and bonus amount of each employee with a bonus **less than** `1000`.
> 
> Return _the result table in **any order**_.
> 
> The query result format is in the following example.

Example
-------

```sh
Input: 
Employee table:
+-------+--------+------------+--------+
| empId | name   | supervisor | salary |
+-------+--------+------------+--------+
| 3     | Brad   | null       | 4000   |
| 1     | John   | 3          | 1000   |
| 2     | Dan    | 3          | 2000   |
| 4     | Thomas | 3          | 4000   |
+-------+--------+------------+--------+
Bonus table:
+-------+-------+
| empId | bonus |
+-------+-------+
| 2     | 500   |
| 4     | 2000  |
+-------+-------+
Output: 
+------+-------+
| name | bonus |
+------+-------+
| Brad | null  |
| John | null  |
| Dan  | 500   |
+------+-------+
```

Solution
--------

| Task | Solution                   |
|:----:|:---------------------------|
| 577  | [Employee Bonus][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/employee-bonus/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h6/p577/option/Practice.java>
