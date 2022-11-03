# [LeetCode][leetcode] task # 181: [Employees Earning More Than Their Managers][task]

Description
-----------

> Table: Employee
```sh
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| salary      | int     |
| managerId   | int     |
+-------------+---------+
```
> id is the primary key column for this table.
> Each row of this table indicates the ID of an employee,
> their name, salary, and the ID of their manager.
> 
> Write an SQL query to find the employees
> who earn more than their managers.
> 
> Return the result table in **any order**.
> 
> The query result format is in the following example.

Example
-------

```sh
Input: 
Employee table:
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | Null      |
| 4  | Max   | 90000  | Null      |
+----+-------+--------+-----------+
Output: 
+----------+
| Employee |
+----------+
| Joe      |
+----------+
Explanation: Joe is the only employee who earns more than his manager.
```

Solution
--------

| Task | Solution                                               |
|:----:|:-------------------------------------------------------|
| 181  | [Employees Earning More Than Their Managers][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/employees-earning-more-than-their-managers/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h2/p181/option/Practice.java>
