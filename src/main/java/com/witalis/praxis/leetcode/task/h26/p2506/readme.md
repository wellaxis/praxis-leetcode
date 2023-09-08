# [LeetCode][leetcode] task # 2506: [Count Pairs Of Similar Strings][task]

Description
-----------

> You are given a **0-indexed** string array `words`.
> 
> Two strings are **similar** if they consist of the same characters.
> * For example, `"abca"` and `"cba"` are similar since both consist of characters 'a', 'b', and 'c'.
> * However, `"abacba"` and `"bcfd"` are not similar since they do not consist of the same characters.
>
> Return _the number of pairs `(i, j)` such that `0 <= i < j <= word.length - 1`
> and the two strings `words[i]` and `words[j]` are similar_.

Example
-------

```sh
Input: words = ["aba","aabb","abcd","bac","aabc"]
Output: 2
Explanation: There are 2 pairs that satisfy the conditions:
    - i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'. 
    - i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'.
```

Solution
--------

| Task | Solution                                   |
|:----:|:-------------------------------------------|
| 2506 | [Count Pairs Of Similar Strings][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/count-pairs-of-similar-strings/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h26/p2506/option/Practice.java>
