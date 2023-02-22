# [LeetCode][leetcode] task # 1011: [Capacity To Ship Packages Within D Days][task]

Description
-----------

> A conveyor belt has packages that must be shipped from one port to another within `days` days.
> 
> The `i^th` package on the conveyor belt has a weight of `weights[i]`.
> Each day, we load the ship with packages on the conveyor belt (in the order given by `weights`).
> We may not load more weight than the maximum weight capacity of the ship.
> 
> Return _the least weight capacity of the ship that will result
> in all the packages on the conveyor belt being shipped within `days` days_.

Example
-------

```sh
Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
    1st day: 1, 2, 3, 4, 5
    2nd day: 6, 7
    3rd day: 8
    4th day: 9
    5th day: 10
    
    Note that the cargo must be shipped in the order given, so using a ship of capacity 14
    and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
```

Solution
--------

| Task | Solution                                            |
|:----:|:----------------------------------------------------|
| 1011 | [Capacity To Ship Packages Within D Days][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1011/option/Practice.java>
