# [LeetCode][leetcode] task # 1220: [Count Vowels Permutation][task]

Description
-----------

> Given an integer `n`, your task is to count how many strings of length `n` can be formed under the following rules:
> * Each character is a lower case vowel (`'a'`, `'e'`, `'i'`, `'o'`, `'u'`)
> * Each vowel `'a'` may only be followed by an `'e'`.
> * Each vowel `'e'` may only be followed by an `'a'` or an `'i'`.
> * Each vowel `'i'` may not be followed by another `'i'`.
> * Each vowel `'o'` may only be followed by an `'i'` or a `'u'`.
> * Each vowel `'u'` may only be followed by an `'a'`.
> 
> Since the answer may be too large, return it **modulo** `10^9 + 7`.

Example
-------

```sh
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
```

Solution
--------

| Task | Solution                             |
|:----:|:-------------------------------------|
| 1220 | [Count Vowels Permutation][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/count-vowels-permutation/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h13/p1220/option/Practice.java>
