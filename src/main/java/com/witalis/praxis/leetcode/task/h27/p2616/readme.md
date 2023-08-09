# [LeetCode][leetcode] task # 2616: [Minimize the Maximum Difference of Pairs][task]

Description
-----------

> You are given a **0-indexed** integer array `nums` and an integer `p`.
> Find `p` pairs of indices of `nums` such that the **maximum** difference amongst all the pairs is **minimized**.
> Also, ensure no index appears more than once amongst the `p` pairs.
> 
> Note that for a pair of elements at the index `i` and `j`,
> the difference of this pair is `|nums[i] - nums[j]|`,
> where `|x|` represents the **absolute value** of `x`.
> 
> Return _the **minimum maximum** difference among all `p` pairs_.
> We define the maximum of an empty set to be zero.

 Example
-------

```sh
Input: nums = [10,1,2,7,1,3], p = 2
Output: 1
Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5. 
    The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.
```

Solution
--------

| Task | Solution                                             |
|:----:|:-----------------------------------------------------|
| 2616 | [Minimize the Maximum Difference of Pairs][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h27/p2616/option/Practice.java>
