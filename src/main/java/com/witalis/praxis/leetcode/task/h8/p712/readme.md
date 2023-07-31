# [LeetCode][leetcode] task # 712: [Minimum ASCII Delete Sum for Two Strings][task]

Description
-----------

> Given two strings `s1` and `s2`, return _the lowest **ASCII** sum of deleted characters to make two strings equal_.

Example
-------

```sh
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
    adds 100[d] + 101[e] + 101[e] to the sum.
    Deleting "e" from "leet" adds 101[e] to the sum.
    At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
    If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
```

Solution
--------

| Task | Solution                                             |
|:----:|:-----------------------------------------------------|
| 712  | [Minimum ASCII Delete Sum for Two Strings][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h8/p712/option/Practice.java>
