# [LeetCode][leetcode] task # 177: [Nth Highest Salary][task]

Description
-----------

> Table: `Employee`
```sh
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
```
> id is the primary key column for this table.
> Each row of this table contains information about the salary of an employee.

> Write an SQL query to report the `n-th` highest salary from the `Employee` table.
> If there is no `n-th` highest salary, the query should report `null`.
> 
> The query result format is in the following example.

Example
-------

```sh
Input: 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
n = 2
Output: 
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
```

Solution
--------

| Task | Solution                       |
|:----:|:-------------------------------|
| 177  | [Nth Highest Salary][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/nth-highest-salary/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p177/option/Practice.java>
