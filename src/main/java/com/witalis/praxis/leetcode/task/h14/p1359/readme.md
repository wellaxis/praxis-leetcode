# [LeetCode][leetcode] task # 1359: [Count All Valid Pickup and Delivery Options][task]

Description
-----------

> Given `n` orders, each order consist in pickup and delivery services.
> 
> Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
> 
> Since the answer may be too large, return it modulo **10^9 + 7**.

Example
-------

```sh
Input: n = 2
Output: 6
Explanation: All possible orders: 
    (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
    This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
```

Solution
--------

| Task | Solution                                                |
|:----:|:--------------------------------------------------------|
| 1359 | [Count All Valid Pickup and Delivery Options][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h14/p1359/option/Practice.java>
