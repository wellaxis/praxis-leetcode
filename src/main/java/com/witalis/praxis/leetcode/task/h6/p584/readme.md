# [LeetCode][leetcode] task # 584: [Find Customer Referee][task]

Description
-----------

> Table: Customer
```sh
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| referee_id  | int     |
+-------------+---------+
```
> id is the primary key column for this table.
> Each row of this table indicates the id of a customer, their name, and the id of the customer who referred them.
>
> Write an SQL query to report the names of the customer that are **not referred by** the customer with `id = 2`.
> 
> Return the result table in **any order**.
> 
> The query result format is in the following example.

Example
-------

```sh
Input: 
Customer table:
+----+------+------------+
| id | name | referee_id |
+----+------+------------+
| 1  | Will | null       |
| 2  | Jane | null       |
| 3  | Alex | 2          |
| 4  | Bill | null       |
| 5  | Zack | 1          |
| 6  | Mark | 2          |
+----+------+------------+
Output: 
+------+
| name |
+------+
| Will |
| Jane |
| Bill |
| Zack |
+------+
```

Solution
--------

| Task | Solution                          |
|:----:|:----------------------------------|
| 584  | [Find Customer Referee][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/find-customer-referee/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h6/p584/option/Practice.java>
