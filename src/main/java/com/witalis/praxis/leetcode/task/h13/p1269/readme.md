# [LeetCode][leetcode] task # 1269: [Number of Ways to Stay in the Same Place After Some Steps][task]

Description
-----------

> You have a pointer at index `0` in an array of size `arrLen`. At each step, you can move `1` position to the left,
> `1` position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).
> 
> Given two integers `steps` and `arrLen`, return _the number of ways such that your pointer is still at index `0`
> after exactly `steps` steps_. Since the answer may be too large, return it **modulo** `10^9 + 7`.

Example
-------

```sh
Input: steps = 3, arrLen = 2
Output: 4
Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
    Right, Left, Stay
    Stay, Right, Left
    Right, Stay, Left
    Stay, Stay, Stay
```

Solution
--------

| Task | Solution                                                              |
|:----:|:----------------------------------------------------------------------|
| 1269 | [Number of Ways to Stay in the Same Place After Some Steps][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h13/p1269/option/Practice.java>
