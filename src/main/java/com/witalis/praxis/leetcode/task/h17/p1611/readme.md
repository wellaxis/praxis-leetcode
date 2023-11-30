# [LeetCode][leetcode] task # 1611: [Minimum One Bit Operations to Make Integers Zero][task]

Description
-----------

> Given an integer `n`, you must transform it into `0` using the following operations any number of times:
> * Change the rightmost (`0^th`) bit in the binary representation of `n`.
> * Change the `i^th` bit in the binary representation of `n` if the `(i-1)^th` bit is set to `1`
> and the `(i-2)^th` through `0^th` bits are set to `0`.
>
> Return _the minimum number of operations to transform `n` into `0`_.

 Example
-------

```sh
Input: n = 6
Output: 4
Explanation: The binary representation of 6 is "110".
    "110" -> "010" with the 2nd operation since the 1st bit is 1 and 0th through 0th bits are 0.
    "010" -> "011" with the 1st operation.
    "011" -> "001" with the 2nd operation since the 0th bit is 1.
    "001" -> "000" with the 1st operation.
```

Solution
--------

| Task | Solution                                                     |
|:----:|:-------------------------------------------------------------|
| 1611 | [Minimum One Bit Operations to Make Integers Zero][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h17/p1611/option/Practice.java>
