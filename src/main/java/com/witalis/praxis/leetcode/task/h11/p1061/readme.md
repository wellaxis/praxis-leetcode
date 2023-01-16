# [LeetCode][leetcode] task # 1061: [Lexicographically Smallest Equivalent String][task]

Description
-----------

> You are given two strings of the same length `s1` and `s2` and a string `baseStr`.
> 
> We say `s1[i]` and `s2[i]` are equivalent characters.
> * For example, if `s1 = "abc"` and `s2 = "cde"`, then we have `'a' == 'c'`, `'b' == 'd'`, and `'c' == 'e'`.
>
> Equivalent characters follow the usual rules of any equivalence relation:
> * Reflexivity: `'a' == 'a'`.
> * Symmetry: `'a' == 'b'` implies `'b' == 'a'`.
> * Transitivity: `'a' == 'b'` and `'b' == 'c'` implies `'a' == 'c'`.
>
> For example, given the equivalency information from `s1 = "abc"` and `s2 = "cde"`,
> `"acd"` and `"aab"` are equivalent strings of `baseStr = "eed"`,
> and `"aab"` is the lexicographically smallest equivalent string of `baseStr`.
> 
> Return _the lexicographically smallest equivalent string of `baseStr`
> by using the equivalency information from `s1` and `s2`_.

Example
-------

```sh
Input: s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in s1 and s2,
    we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
    The characters in each group are equivalent and sorted in lexicographical order.
    So the answer is "makkek".
```

Solution
--------

| Task | Solution                                                 |
|:----:|:---------------------------------------------------------|
| 1061 | [Lexicographically Smallest Equivalent String][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/lexicographically-smallest-equivalent-string/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1061/option/Practice.java>
