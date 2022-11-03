# [LeetCode][leetcode] task # 682: [Baseball Game][task]

Description
-----------

> You are keeping the scores for a baseball game with strange rules.
> At the beginning of the game, you start with an empty record.
> 
> You are given a list of strings `operations`, where `operations[i]`
> is the `i^th` operation you must apply to the record and is one of the following:
> * An integer `x`.
>     * Record a new score of x.
> * '+'.
>     * Record a new score that is the sum of the previous two scores.
> * 'D'.
>     * Record a new score that is the double of the previous score.
> * 'C'.
>     * Invalidate the previous score, removing it from the record.
>
> Return _the sum of all the scores on the record after applying all the operations_.
> 
> The test cases are generated such that the answer and all intermediate calculations
> fit in a **32-bit** integer and that all operations are valid.

Example
-------

```sh
Input: ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation:
    "5" - Add 5 to the record, record is now [5].
    "-2" - Add -2 to the record, record is now [5, -2].
    "4" - Add 4 to the record, record is now [5, -2, 4].
    "C" - Invalidate and remove the previous score, record is now [5, -2].
    "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
    "9" - Add 9 to the record, record is now [5, -2, -4, 9].
    "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
    "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
    The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
```

Solution
--------

| Task | Solution                  |
|:----:|:--------------------------|
| 682  | [Baseball Game][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/baseball-game/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h7/p682/option/Practice.java>
