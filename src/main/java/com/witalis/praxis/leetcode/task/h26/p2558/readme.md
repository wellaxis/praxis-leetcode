# [LeetCode][leetcode] task # 2558: [Take Gifts From the Richest Pile][task]

Description
-----------

> You are given an integer array `gifts` denoting the number of gifts in various piles.
> Every second, you do the following:
> * Choose the pile with the maximum number of gifts.
> * If there is more than one pile with the maximum number of gifts, choose any.
> * Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.
>
> Return _the number of gifts remaining after `k` seconds_.

 Example
-------

```sh
Input: gifts = [25,64,9,4,100], k = 4
Output: 29
Explanation: 
    The gifts are taken in the following way:
    - In the first second, the last pile is chosen and 10 gifts are left behind.
    - Then the second pile is chosen and 8 gifts are left behind.
    - After that the first pile is chosen and 5 gifts are left behind.
    - Finally, the last pile is chosen again and 3 gifts are left behind.
    The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29. 
```

Solution
--------

| Task | Solution                                     |
|:----:|:---------------------------------------------|
| 2558 | [Take Gifts From the Richest Pile][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/take-gifts-from-the-richest-pile/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h26/p2558/option/Practice.java>
