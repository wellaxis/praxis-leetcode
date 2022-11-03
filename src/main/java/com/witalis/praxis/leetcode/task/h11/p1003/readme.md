# [LeetCode][leetcode] task # 1003: [Check If Word Is Valid After Substitutions][task]

Description
-----------

> Given a string `s`, determine if it is **valid**.
> 
> A string `s` is **valid** if, starting with an empty string `t = ""`,
> you can **transform** `t` **into** `s` after performing the following operation **any number of times**:
> * Insert string `"abc"` into any position in `t`.
> More formally, `t` becomes `tleft + "abc" + tright`, where `t == tleft + tright`.
> Note that `tleft` and `tright` may be **empty**.
>
> Return _`true` if `s` is a **valid** string, otherwise, return `false`_.

Example
-------

```sh
Input: s = "abcabcababcc"
Output: true
Explanation:
"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
Thus, "abcabcababcc" is valid.
```

Solution
--------

| Task | Solution                                               |
|:----:|:-------------------------------------------------------|
| 1003 | [Check If Word Is Valid After Substitutions][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1003/option/Practice.java>
