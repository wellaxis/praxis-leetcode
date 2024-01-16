# [LeetCode][leetcode] task # 2225: [Find Players With Zero or One Losses][task]

Description
-----------

> You are given an integer array `matches` where `matches[i] = [winner[i], loser[i]]`
> indicates that the player `winner[i]` defeated player `loser[i]` in a match.
> 
> Return _a list `answer` of size `2` where_:
> * `answer[0]` is a list of all players that have **not** lost any matches.
> * `answer[1]` is a list of all players that have lost exactly **one** match.
>
> The values in the two lists should be returned in **increasing** order.
> 
> **Note:**
> * You should only consider the players that have played **at least one** match.
> * The testcases will be generated such that **no** two matches will have the **same** outcome.

Example
-------

```sh
Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Explanation:
    Players 1, 2, and 10 have not lost any matches.
    Players 4, 5, 7, and 8 each have lost one match.
    Players 3, 6, and 9 each have lost two matches.
Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
```

Solution
--------

| Task | Solution                                         |
|:----:|:-------------------------------------------------|
| 2225 | [Find Players With Zero or One Losses][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/find-players-with-zero-or-one-losses/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h23/p2225/option/Practice.java>
