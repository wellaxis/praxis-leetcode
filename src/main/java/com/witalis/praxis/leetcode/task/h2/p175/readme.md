# [LeetCode][leetcode] task # 175: [Combine Two Tables][task]

Description
-----------

> Table: `Person`
```sh
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| personId    | int     |
| lastName    | varchar |
| firstName   | varchar |
+-------------+---------+
```
> personId is the primary key column for this table.
> This table contains information about the ID
> of some persons and their first and last names.

> Table: `Address`
```sh
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| addressId   | int     |
| personId    | int     |
| city        | varchar |
| state       | varchar |
+-------------+---------+
```
> addressId is the primary key column for this table.
> Each row of this table contains information about
> the city and state of one person with ID = PersonId.
>
> Write an SQL query to report the first name, last name,
> city, and state of each person in the Person table.
> If the address of a personId is not present
> in the Address table, report null instead.
> 
> Return the result table in any order.
>
> The query result format is in the following example.

Example
-------

```sh
Input: 
Person table:
+----------+----------+-----------+
| personId | lastName | firstName |
+----------+----------+-----------+
| 1        | Wang     | Allen     |
| 2        | Alice    | Bob       |
+----------+----------+-----------+
Address table:
+-----------+----------+---------------+------------+
| addressId | personId | city          | state      |
+-----------+----------+---------------+------------+
| 1         | 2        | New York City | New York   |
| 2         | 3        | Leetcode      | California |
+-----------+----------+---------------+------------+
Output: 
+-----------+----------+---------------+----------+
| firstName | lastName | city          | state    |
+-----------+----------+---------------+----------+
| Allen     | Wang     | Null          | Null     |
| Bob       | Alice    | New York City | New York |
+-----------+----------+---------------+----------+
Explanation: 
There is no address in the address table for the personId = 1
so we return null in their city and state.
addressId = 1 contains information about the address of personId = 2.
```

Solution
--------

| Task | Solution                       |
|:----:|:-------------------------------|
| 175  | [Combine Two Tables][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/combine-two-tables/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p175/option/Practice.java>
