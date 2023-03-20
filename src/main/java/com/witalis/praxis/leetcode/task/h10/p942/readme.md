# [LeetCode][leetcode] task # 942: [DI String Match][task]

Description
-----------

> A permutation `perm` of `n + 1` integers of all the integers in the range `[0, n]`
> can be represented as a string `s` of length `n` where:
> * `s[i] == 'I'` if `perm[i] < perm[i + 1]`, and
> * `s[i] == 'D'` if `perm[i] > perm[i + 1]`.
>
> Given a string `s`, reconstruct the permutation `perm` and return it.
> If there are multiple valid permutations perm, return **any of them**.

Example
-------

```sh
Input: s = "IDID"
Output: [0,4,1,3,2]
```

Solution
--------

| Task | Solution                    |
|:----:|:----------------------------|
| 942  | [DI String Match][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/di-string-match/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h10/p942/option/Practice.java>
