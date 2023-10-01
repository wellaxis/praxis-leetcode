# [LeetCode][leetcode] task # 1021: [Remove Outermost Parentheses][task]

Description
-----------

> A valid parentheses string is either empty `""`, `"(" + A + ")"`, or `A + B`,
> where `A` and `B` are valid parentheses strings, and `+` represents string concatenation.
> 
> * For example, `""`, `"()"`, `"(())()"`, and `"(()(()))"` are all valid parentheses strings.
> 
> A valid parentheses string `s` is primitive if it is nonempty, and there does not exist a way
> to split it into `s = A + B`, with `A` and `B` nonempty valid parentheses strings.
> 
> Given a valid parentheses string `s`, consider its primitive decomposition: `s = P1 + P2 + ... + Pk`,
> where `Pi` are primitive valid parentheses strings.
> 
> Return _`s` after removing the outermost parentheses of every primitive string in the primitive decomposition of `s`_.

Example
-------

```sh
Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
    The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
    After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 1021 | [Remove Outermost Parentheses][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/remove-outermost-parentheses/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1021/option/Practice.java>
