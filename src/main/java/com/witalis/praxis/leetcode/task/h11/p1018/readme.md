# [LeetCode][leetcode] task # 1018: [Binary Prefix Divisible By 5][task]

Description
-----------

> You are given a binary array `nums` (**0-indexed**).
> 
> We define `xi` as the number whose binary representation is the subarray `nums[0..i]`
> (from most-significant-bit to least-significant-bit).
> 
> * For example, if `nums = [1,0,1]`, then `x0 = 1`, `x1 = 2`, and `x2 = 5`.
> 
> Return _an array of booleans `answer` where `answer[i]` is `true` if `xi` is divisible by `5`_.

Example
-------

```sh
Input: nums = [0,1,1]
Output: [true,false,false]
Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
    Only the first number is divisible by 5, so answer[0] is true.
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 1018 | [Binary Prefix Divisible By 5][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/binary-prefix-divisible-by-5/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1018/option/Practice.java>
