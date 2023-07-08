# [LeetCode][leetcode] task # 2551: [Put Marbles in Bags][task]

Description
-----------

> You have `k` bags. You are given a **0-indexed** integer array `weights`
> where `weights[i]` is the weight of the `i^th` marble.
> You are also given the integer `k`.
> 
> Divide the marbles into the `k` bags according to the following rules:
> * No bag is empty.
> * If the `i^th` marble and `j^th` marble are in a bag, then all marbles
> with an index between the `i^th` and `j^th` indices should also be in that same bag.
> * If a bag consists of all the marbles with an index from `i` to `j` inclusively,
> then the cost of the bag is `weights[i] + weights[j]`.
>
> The **score** after distributing the marbles is the sum of the costs of all the `k` bags.
> 
> Return _the difference between the **maximum** and **minimum** scores among marble distributions_.

 Example
-------

```sh
Input: weights = [1,3,5,1], k = 2
Output: 4
Explanation: 
    The distribution [1],[3,5,1] results in the minimal score of (1+1) + (3+1) = 6. 
    The distribution [1,3],[5,1], results in the maximal score of (1+3) + (5+1) = 10. 
    Thus, we return their difference 10 - 6 = 4.
```

Solution
--------

| Task | Solution                        |
|:----:|:--------------------------------|
| 2551 | [Put Marbles in Bags][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/put-marbles-in-bags/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h26/p2551/option/Practice.java>
