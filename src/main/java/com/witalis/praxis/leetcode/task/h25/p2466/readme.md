# [LeetCode][leetcode] task # 2466: [Count Ways To Build Good Strings][task]

Description
-----------

> Given the integers `zero`, `one`, `low`, and `high`, we can construct a string by starting with an empty string,
> and then at each step perform either of the following:
> * Append the character `'0'` zero times.
> * Append the character `'1'` one times.
>
> This can be performed any number of times.
> 
> A **good** string is a string constructed by the above process having a **length** between `low` and `high` (**inclusive**).
> 
> Return _the number of **different** good strings that can be constructed satisfying these properties_.
> Since the answer can be large, return it **modulo** `10^9 + 7`.

Example
-------


```sh
Input: low = 2, high = 3, zero = 1, one = 2
Output: 5
Explanation: The good strings are "00", "11", "000", "110", and "011".
```

Solution
--------

| Task | Solution                                     |
|:----:|:---------------------------------------------|
| 2466 | [Count Ways To Build Good Strings][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/count-ways-to-build-good-strings/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h25/p2466/option/Practice.java>
