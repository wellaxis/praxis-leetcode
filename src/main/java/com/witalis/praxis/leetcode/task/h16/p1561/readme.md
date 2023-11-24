# [LeetCode][leetcode] task # 1561: [Maximum Number of Coins You Can Get][task]

Description
-----------

> There are `3n` piles of coins of varying size, you and your friends will take piles of coins as follows:
> * In each step, you will choose **any** `3` piles of coins (not necessarily consecutive).
> * Of your choice, Alice will pick the pile with the maximum number of coins.
> * You will pick the next pile with the maximum number of coins.
> * Your friend Bob will pick the last pile.
> * Repeat until there are no more piles of coins.
>
> Given an array of integers `piles` where `piles[i]` is the number of coins in the `i^th` pile.
> 
> Return _the maximum number of coins that you can have_.

Example
-------

```sh
Input: piles = [2,4,1,2,7,8]
Output: 9
Explanation: Choose the triplet (2, 7, 8), Alice Pick the pile with 8 coins, you the pile with 7 coins and Bob the last one.
    Choose the triplet (1, 2, 4), Alice Pick the pile with 4 coins, you the pile with 2 coins and Bob the last one.
    The maximum number of coins which you can have are: 7 + 2 = 9.
    On the other hand if we choose this arrangement (1, 2, 8), (2, 4, 7) you only get 2 + 4 = 6 coins which is not optimal.
```

Solution
--------

| Task | Solution                                        |
|:----:|:------------------------------------------------|
| 1561 | [Maximum Number of Coins You Can Get][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/maximum-number-of-coins-you-can-get/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h16/p1561/option/Practice.java>
