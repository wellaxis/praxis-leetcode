# [LeetCode][leetcode] task # 837: [New 21 Game][task]

Description
-----------

> Alice plays the following game, loosely based on the card game **"21"**.
> 
> Alice starts with `0` points and draws numbers while she has less than `k` points.
> During each draw, she gains an integer number of points randomly from the range `[1, maxPts]`,
> where `maxPts` is an integer. Each draw is independent and the outcomes have equal probabilities.
> 
> Alice stops drawing numbers when she gets `k` **or more points**.
> 
> Return _the probability that Alice has `n` or fewer points_.
> 
> Answers within `10^-5` of the actual answer are considered accepted.

 Example
-------

```sh
Input: n = 6, k = 1, maxPts = 10
Output: 0.60000
Explanation: Alice gets a single card, then stops.
    In 6 out of 10 possibilities, she is at or below 6 points.
```

Solution
--------

| Task | Solution                |
|:----:|:------------------------|
| 837  | [New 21 Game][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/new-21-game/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h9/p837/option/Practice.java>
