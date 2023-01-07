# [LeetCode][leetcode] task # 2011: [Final Value of Variable After Performing Operations][task]

Description
-----------

> There is a programming language with only **four** operations and **one** variable `X`:
> * `++X` and `X++` **increments** the value of the variable `X` by `1`.
> * `--X` and `X--` **decrements** the value of the variable `X` by `1`.
>
> Initially, the value of `X` is `0`.
> 
> Given an array of strings `operations` containing a list of operations,
> return _the **final** value of `X` after performing all the operations_.

Example
-------

```sh
Input: operations = ["X++","++X","--X","X--"]
Output: 0
Explanation: The operations are performed as follows:
Initially, X = 0.
X++: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
--X: X is decremented by 1, X = 2 - 1 = 1.
X--: X is decremented by 1, X = 1 - 1 = 0.
```

Solution
--------

| Task | Solution                                                        |
|:----:|:----------------------------------------------------------------|
| 2011 | [Final Value of Variable After Performing Operations][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/final-value-of-variable-after-performing-operations/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h21/p2011/option/Practice.java>
