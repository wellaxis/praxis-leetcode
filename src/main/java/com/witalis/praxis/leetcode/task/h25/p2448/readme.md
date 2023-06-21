# [LeetCode][leetcode] task # 2448: [Minimum Cost to Make Array Equal][task]

Description
-----------

> You are given two **0-indexed** arrays `nums` and `cost` consisting each of `n` **positive** integers.
> 
> You can do the following operation **any** number of times:
> * Increase or decrease **any** element of the array `nums` by `1`.
>
> The cost of doing one operation on the `i^th` element is `cost[i]`.
> 
> Return _the **minimum** total cost such that all the elements of the array `nums` become **equal**_.

Example
-------


```sh
Input: nums = [1,3,5,2], cost = [2,3,1,14]
Output: 8
Explanation: We can make all the elements equal to 2 in the following way:
    - Increase the 0th element one time. The cost is 2.
    - Decrease the 1st element one time. The cost is 3.
    - Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
    The total cost is 2 + 3 + 3 = 8.
It can be shown that we cannot make the array equal with a smaller cost.
```

Solution
--------

| Task | Solution                                     |
|:----:|:---------------------------------------------|
| 2448 | [Minimum Cost to Make Array Equal][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimum-cost-to-make-array-equal/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h25/p2448/option/Practice.java>
