# [LeetCode][leetcode] task # 1685: [Sum of Absolute Differences in a Sorted Array][task]

Description
-----------

> You are given an integer array `nums` sorted in **non-decreasing** order.
> 
> Build and return _an integer array `result` with the same length as `nums` such that `result[i]` is equal
> to the **summation of absolute differences** between `nums[i]` and all the other elements in the array_.
> 
> In other words, `result[i]` is equal to `sum(|nums[i]-nums[j]|)` where `0 <= j < nums.length` and `j != i` (**0-indexed**).

Example
-------

```sh
Input: nums = [2,3,5]
Output: [4,3,5]
Explanation: Assuming the arrays are 0-indexed, then
    result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
    result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
    result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
```

Solution
--------

| Task | Solution                                                  |
|:----:|:----------------------------------------------------------|
| 1685 | [Sum of Absolute Differences in a Sorted Array][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h17/p1685/option/Practice.java>
