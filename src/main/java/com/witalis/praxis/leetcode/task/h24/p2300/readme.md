# [LeetCode][leetcode] task # 2300: [Successful Pairs of Spells and Potions][task]

Description
-----------

> You are given two positive integer arrays `spells` and `potions`, of length `n` and `m` respectively,
> where `spells[i]` represents the strength of the `i^th` spell and `potions[j]` represents the strength of the `j^th` potion.
> 
> You are also given an integer `success`.
> A spell and potion pair is considered **successful** if the **product** of their strengths is **at least** `success`.
> 
> Return _an integer array `pairs` of length `n` where `pairs[i]`
> is the number of **potions** that will form a successful pair with the `i^th` spell.

 Example
-------

```sh
Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
    - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
    - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
    - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
Thus, [4,0,3] is returned.
```

Solution
--------

| Task | Solution                                           |
|:----:|:---------------------------------------------------|
| 2300 | [Successful Pairs of Spells and Potions][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/successful-pairs-of-spells-and-potions/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h24/p2300/option/Practice.java>
