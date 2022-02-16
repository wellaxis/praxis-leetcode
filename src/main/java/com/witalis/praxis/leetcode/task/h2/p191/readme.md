# [LeetCode][leetcode] task # 191: [Number of 1 Bits][task]

Description
-----------

> Write a function that takes an unsigned integer and returns
> the number of '1' bits it has (also known as the [Hamming weight][hamming]).
> 
> **Note**:
> * Note that in some languages, such as Java, there is no unsigned integer type.
> In this case, the input will be given as a signed integer type.
> It should not affect your implementation, as the integer's internal
> binary representation is the same, whether it is signed or unsigned.
> * In Java, the compiler represents the signed integers using
> `2's complement notation`. Therefore, in **Example 3**,
> the input represents the signed integer. `-3`.

Example
-------

```sh
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011
    has a total of three '1' bits.
```

> Constraints:
> * The input must be a **binary string** of length `32`.

> Follow up:
> If this function is called many times, how would you optimize it?

Solution
--------

| Task | Solution                     |
|:----:|:-----------------------------|
| 191  | [Number of 1 Bits][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/number-of-1-bits/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p191/option/Practice.java>
[hamming]: <https://en.wikipedia.org/wiki/Hamming_weight>