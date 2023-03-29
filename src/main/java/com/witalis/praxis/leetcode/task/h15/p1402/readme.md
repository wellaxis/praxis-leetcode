# [LeetCode][leetcode] task # 1402: [Reducing Dishes][task]

Description
-----------

> A chef has collected data on the `satisfaction` level of his `n` dishes. Chef can cook any dish in 1 unit of time.
> 
> **Like-time coefficient** of a dish is defined as the time taken to cook that dish including previous dishes
> multiplied by its satisfaction level i.e. `time[i] * satisfaction[i]`.
> 
> Return _the maximum sum of **like-time coefficient** that the chef can obtain after dishes preparation_.
> 
> Dishes can be prepared in **any* order and the chef can discard some dishes to get this maximum value.

Example
-------

```sh
Input: satisfaction = [-1,-8,0,5,-9]
Output: 14
Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
Each dish is prepared in one unit of time.
```

Solution
--------

| Task | Solution                    |
|:----:|:----------------------------|
| 1402 | [Reducing Dishes][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/reducing-dishes/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h15/p1402/option/Practice.java>
