# [LeetCode][leetcode] task # 495: [Teemo Attacking][task]

Description
-----------

> Our hero Teemo is attacking an enemy Ashe with poison attacks!
> When Teemo attacks Ashe, Ashe gets poisoned for a exactly `duration` seconds.
> More formally, an attack at second `t` will mean Ashe is poisoned
> during the **inclusive** time interval `[t, t + duration - 1]`.
> If Teemo attacks again **before** the poison effect ends,
> the timer for it is **reset**, and the poison effect will end `duration` seconds after the new attack.
> 
> You are given a **non-decreasing** integer array `timeSeries`, where `timeSeries[i]` denotes
> that Teemo attacks Ashe at second `timeSeries[i]`, and an integer `duration`.
> 
> Return _the **total** number of seconds that Ashe is poisoned_.

 Example
-------

```sh
Input: timeSeries = [1,4], duration = 2
Output: 4
Explanation: Teemo's attacks on Ashe go as follows:
    - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
    - At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
    Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.
```

Solution
--------

| Task | Solution                    |
|:----:|:----------------------------|
| 495  | [Teemo Attacking][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/teemo-attacking/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h5/p495/option/Practice.java>
