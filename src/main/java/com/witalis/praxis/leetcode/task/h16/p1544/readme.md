# [LeetCode][leetcode] task # 1544: [Make The String Great][task]

Description
-----------

> Given a string `s` of lower and upper case English letters.
> 
> A good string is a string which doesn't have **two adjacent characters** `s[i]` and `s[i + 1]` where:
> * `0 <= i <= s.length - 2`
> * `s[i]` is a lower-case letter and `s[i + 1]` is the same letter but in upper-case or **vice-versa**.
>
> To make the string good, you can choose two adjacent characters that make the string bad and remove them.
> You can keep doing this until the string becomes good.
> 
> Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
> 
> **Notice** that an empty string is also good.

Example
-------

```sh
Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
    "abBAcC" --> "aAcC" --> "cC" --> ""
    "abBAcC" --> "abBA" --> "aA" --> ""
```

Solution
--------

| Task | Solution                          |
|:----:|:----------------------------------|
| 1544 | [Make The String Great][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/make-the-string-great/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h16/p1544/option/Practice.java>
