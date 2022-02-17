# [LeetCode][leetcode] task # 183: [Customers Who Never Order][task]

Description
-----------

> Table: Customers
```sh
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
```
> id is the primary key column for this table.
> Each row of this table indicates the ID and name of a customer.

> Table: Orders
```sh
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| customerId  | int  |
+-------------+------+
```
> id is the primary key column for this table.
> customerId is a foreign key of the ID from the Customers table.
> Each row of this table indicates the ID of an order
> and the ID of the customer who ordered it.

> Write an SQL query to report all customers who never order anything.
> 
> Return the result table in **any order**.
> 
> The query result format is in the following example.

Example
-------

```sh
Input: 
Customers table:
+----+-------+
| id | name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders table:
+----+------------+
| id | customerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Output: 
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```

Solution
--------

| Task | Solution                              |
|:----:|:--------------------------------------|
| 183  | [Customers Who Never Order][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/customers-who-never-order/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p183/option/Practice.java>
