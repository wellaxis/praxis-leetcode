# [LeetCode][leetcode] task # 1140: [Stone Game II][task]

Description
-----------

> Alice and Bob continue their games with piles of stones.
> There are a number of piles **arranged in a row**, and each pile has a positive integer number of stones `piles[i]`.
> The objective of the game is to end with the most stones.
> 
> Alice and Bob take turns, with Alice starting first. Initially, `M = 1`.
> 
> On each player's turn, that player can take **all the stones** in the **first** `X` remaining piles,
> where `1 <= X <= 2M`. Then, we set `M = max(M, X)`.
> 
> The game continues until all the stones have been taken.
> 
> Assuming Alice and Bob play optimally, return _the maximum number of stones Alice can get_.

Example
-------

```sh
Input: piles = [2,7,9,4,4]
Output: 10
Explanation:
    If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again.
        Alice can get 2 + 4 + 4 = 10 piles in total.
    If Alice takes two piles at the beginning, then Bob can take all three piles left.
        In this case, Alice get 2 + 7 = 9 piles in total.
    So we return 10 since it's larger.
```

Solution
--------

| Task | Solution                  |
|:----:|:--------------------------|
| 1140 | [Stone Game II][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/stone-game-ii/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h12/p1140/option/Practice.java>
