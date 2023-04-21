# [LeetCode][leetcode] task # 879: [Profitable Schemes][task]

Description
-----------

> There is a group of `n` members, and a list of various crimes they could commit.
> The `i^th` crime generates a `profit[i]` and requires `group[i]` members to participate in it.
> If a member participates in one crime, that member can't participate in another crime.
> 
> Let's call a **profitable scheme** any subset of these crimes that generates at least `minProfit` profit,
> and the total number of members participating in that subset of crimes is at most `n`.
> 
> Return _the number of schemes that can be chosen_. Since the answer may be very large, **return it modulo** `10^9 + 7`.

 Example
-------

```sh
Input: n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
Output: 7
Explanation: To make a profit of at least 5, the group could commit any crimes, as long as they commit one.
    There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
```

Solution
--------

| Task | Solution                       |
|:----:|:-------------------------------|
| 879  | [Profitable Schemes][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/profitable-schemes/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h9/p879/option/Practice.java>
