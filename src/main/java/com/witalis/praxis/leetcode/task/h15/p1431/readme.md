# [LeetCode][leetcode] task # 1431: [Kids With the Greatest Number of Candies][task]

Description
-----------

> There are `n` kids with candies. You are given an integer array `candies`, where each `candies[i]` represents
> the number of candies the `i^th` kid has, and an integer `extraCandies`, denoting the number of extra candies that you have.
> 
> Return _a boolean array `result` of length `n`, where `result[i]` is `true` if, after giving the `i^th` kid all the extraCandies,
> they will have the **greatest** number of candies among all the kids, or `false` otherwise_.
> 
> Note that **multiple** kids can have the **greatest** number of candies.

Example
-------

```sh
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true] 
Explanation: If you give all extraCandies to:
    - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
    - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
    - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
    - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
    - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
```

Solution
--------

| Task | Solution                                             |
|:----:|:-----------------------------------------------------|
| 1431 | [Kids With the Greatest Number of Candies][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h15/p1431/option/Practice.java>
