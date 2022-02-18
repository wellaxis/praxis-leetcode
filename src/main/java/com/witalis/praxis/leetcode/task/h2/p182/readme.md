# [LeetCode][leetcode] task # 182: [Duplicate Emails][task]

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
> Write an SQL query to report all the duplicate emails.
> 
> Return the result table in **any order**.
> 
> The query result format is in the following example.

Example
-------

```sh
Input: 
Person table:
+----+---------+
| id | email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
Output: 
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Explanation: a@b.com is repeated two times.
```

Solution
--------

| Task | Solution                     |
|:----:|:-----------------------------|
| 182  | [Duplicate Emails][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/duplicate-emails/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p182/option/Practice.java>
