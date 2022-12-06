# [LeetCode][leetcode] task # 1701: [Average Waiting Time][task]

Description
-----------

> There is a restaurant with a single chef.
> You are given an array `customers`, where `customers[i] = [arrival^i, time^i]`:
> * `arrival^i` is the arrival time of the `i^th` customer. The arrival times are sorted in **non-decreasing** order.
> * `time^i` is the time needed to prepare the order of the `i^th` customer.
> 
> When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle.
> The customer waits till the chef finishes preparing his order.
> The chef does not prepare food for more than one customer at a time.
> The chef prepares food for customers **in the order they were given in the input**.
> 
> Return _the **average** waiting time of all customers_.
> Solutions within 10^-5 from the actual answer are considered accepted.

Example
-------

```sh
Input: customers = [[1,2],[2,5],[4,3]]
Output: 5.00000
Explanation:
    1) The first customer arrives at time 1, the chef takes his order and starts preparing it immediately at time 1,
       and finishes at time 3, so the waiting time of the first customer is 3 - 1 = 2.
    2) The second customer arrives at time 2, the chef takes his order and starts preparing it at time 3,
       and finishes at time 8, so the waiting time of the second customer is 8 - 2 = 6.
    3) The third customer arrives at time 4, the chef takes his order and starts preparing it at time 8,
       and finishes at time 11, so the waiting time of the third customer is 11 - 4 = 7.
    So the average waiting time = (2 + 6 + 7) / 3 = 5.
```

Solution
--------

| Task | Solution                         |
|:----:|:---------------------------------|
| 1701 | [Average Waiting Time][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/average-waiting-time/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h18/p1701/option/Practice.java>
