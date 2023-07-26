# [LeetCode][leetcode] task # 1870: [Minimum Speed to Arrive on Time][task]

Description
-----------

> You are given a floating-point number `hour`, representing the amount of time you have to reach the office.
> To commute to the office, you must take `n` trains in sequential order.
> You are also given an integer array `dist` of length `n`,
> where `dist[i]` describes the distance (in kilometers) of the `i^th` train ride.
> 
> Each train can only depart at an integer hour, so you may need to wait in between each train ride.
> * For example, if the `1st` train ride takes `1.5` hours, you must wait for an additional `0.5` hours
> before you can depart on the `2nd` train ride at the `2` hour mark.
>
> Return _the **minimum positive integer** speed (**in kilometers per hour**)
> that all the trains must travel at for you to reach the office on time, or `-1` if it is impossible to be on time_.
> 
> Tests are generated such that the answer will not exceed `10^7`
> and `hour` will have **at most two digits after the decimal point**.

 Example
-------


```sh
Input: dist = [1,3,2], hour = 2.7
Output: 3
Explanation: At speed 3:
    - The first train ride takes 1/3 = 0.33333 hours.
    - Since we are not at an integer hour, we wait until the 1 hour mark to depart. The second train ride takes 3/3 = 1 hour.
    - Since we are already at an integer hour, we depart immediately at the 2 hour mark. The third train takes 2/3 = 0.66667 hours.
    - You will arrive at the 2.66667 hour mark.
```

Solution
--------

| Task | Solution                                    |
|:----:|:--------------------------------------------|
| 1870 | [Minimum Speed to Arrive on Time][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimum-speed-to-arrive-on-time/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h19/p1870/option/Practice.java>
