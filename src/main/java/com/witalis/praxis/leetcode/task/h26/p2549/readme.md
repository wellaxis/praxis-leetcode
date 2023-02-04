# [LeetCode][leetcode] task # 2549: [Count Distinct Numbers on Board][task]

Description
-----------

> You are given a positive integer `n`, that is initially placed on a board.
> Every day, for `10^9` days, you perform the following procedure:
> * For each number `x` present on the board, find all numbers `1 <= i <= n` such that `x % i == 1`.
> * Then, place those numbers on the board.
>
> Return _the number of **distinct** integers present on the board after `10^9` days have elapsed_.
> 
> **Note:**
> * Once a number is placed on the board, it will remain on it until the end.
> * `%` stands for the modulo operation. For example, `14 % 3` is `2`.

 Example
-------

```sh
Input: n = 5
Output: 4
Explanation: Initially, 5 is present on the board. 
    The next day, 2 and 4 will be added since 5 % 2 == 1 and 5 % 4 == 1. 
    After that day, 3 will be added to the board because 4 % 3 == 1. 
    At the end of a billion days, the distinct numbers on the board will be 2, 3, 4, and 5. 
```

Solution
--------

| Task | Solution                                    |
|:----:|:--------------------------------------------|
| 2549 | [Count Distinct Numbers on Board][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/count-distinct-numbers-on-board/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h26/p2549/option/Practice.java>
