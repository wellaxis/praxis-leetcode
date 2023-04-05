# [LeetCode][leetcode] task # 2439: [Minimize Maximum of Array][task]

Description
-----------

> You are given a **0-indexed** array `nums` comprising of `n` non-negative integers.
> 
> In one operation, you must:
> * Choose an integer `i` such that `1 <= i < n` and `nums[i] > 0`.
> * Decrease `nums[i]` by 1.
> * Increase `nums[i - 1]` by 1.
>
> Return _the **minimum** possible value of the **maximum** integer of `nums` after performing **any** number of operations_.

 Example
-------

```sh
Input: nums = [3,7,1,6]
Output: 5
Explanation:
    One set of optimal operations is as follows:
    1. Choose i = 1, and nums becomes [4,6,1,6].
    2. Choose i = 3, and nums becomes [4,6,2,5].
    3. Choose i = 1, and nums becomes [5,5,2,5].
    The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
    Therefore, we return 5.
```

Solution
--------

| Task | Solution                              |
|:----:|:--------------------------------------|
| 2439 | [Minimize Maximum of Array][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimize-maximum-of-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h25/p2439/option/Practice.java>
