# [LeetCode][leetcode] task # 196: [Delete Duplicate Emails][task]

Description
-----------

> Table: Person
```sh
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
```
> id is the primary key column for this table.
> Each row of this table contains an email.
> The emails will not contain uppercase letters.
>
> Write an SQL query to **delete** all the duplicate emails,
> keeping only one unique email with the smallest `id`.
> Note that you are supposed to write a `DELETE` statement and not a `SELECT` one.
> 
> Return the result table in **any order**.
> 
> The query result format is in the following example.

Example
-------

```sh
Input:
Person table:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Output: 
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
Explanation:
    john@example.com is repeated two times.
    We keep the row with the smallest Id = 1.
```

Solution
--------

| Task | Solution                            |
|:----:|:------------------------------------|
| 196  | [Delete Duplicate Emails][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/delete-duplicate-emails/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p196/option/Practice.java>
