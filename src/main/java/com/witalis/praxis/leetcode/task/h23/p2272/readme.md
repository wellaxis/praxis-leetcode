# [LeetCode][leetcode] task # 2272: [Substring With Largest Variance][task]

Description
-----------

> The **variance** of a string is defined as the largest difference between the number of occurrences
> of **any** `2` characters present in the string. Note the two characters may or may not be the same.
> 
> Given a string `s` consisting of lowercase English letters only,
> return _the **largest variance** possible among all **substrings** of `s`_.
> 
> A **substring** is a contiguous sequence of characters within a string.

Example
-------

```sh
Input: s = "aababbb"
Output: 3
Explanation:
    All possible variances along with their respective substrings are listed below:
    - Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
    - Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
    - Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
    - Variance 3 for substring "babbb".
    Since the largest possible variance is 3, we return it.
```

Solution
--------

| Task | Solution                                    |
|:----:|:--------------------------------------------|
| 2272 | [Substring With Largest Variance][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/substring-with-largest-variance/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h23/p2272/option/Practice.java>
