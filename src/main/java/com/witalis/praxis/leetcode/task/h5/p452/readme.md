# [LeetCode][leetcode] task # 452: [Minimum Number of Arrows to Burst Balloons][task]

Description
-----------

> There are some spherical balloons taped onto a flat wall that represents the XY-plane.
> The balloons are represented as a 2D integer array `points` where `points[i] = [x-start, x-end]` denotes a balloon
> whose **horizontal diameter** stretches between `x-start` and `x-end`.
> You do not know the exact y-coordinates of the balloons.
> 
> Arrows can be shot up **directly vertically** (in the positive y-direction) from different points along the x-axis.
> A balloon with `x-start` and `x-end` is burst by an arrow shot at `x` if `x-start <= x <= x-end`.
> There is **no limit** to the number of arrows that can be shot.
> A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
> 
> Given the array `points`, return _the **minimum** number of arrows that must be shot to burst all balloons_.

Example
-------


```sh
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
```

Solution
--------

| Task | Solution                                               |
|:----:|:-------------------------------------------------------|
| 452  | [Minimum Number of Arrows to Burst Balloons][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h5/p452/option/Practice.java>
