# [LeetCode][leetcode] task # 1531: [String Compression II][task]

Description
-----------

> [Run-length encoding](http://en.wikipedia.org/wiki/Run-length_encoding) is a string compression method
> that works by replacing consecutive identical characters (repeated 2 or more times)
> with the concatenation of the character and the number marking the count of the characters (length of the run).
> For example, to compress the string `"aabccc"` we replace `"aa"` by `"a2"` and replace `"ccc"` by `"c3"`.
> Thus the compressed string becomes `"a2bc3"`.
> 
> Notice that in this problem, we are not adding `'1'` after single characters.
> 
> Given a string `s` and an integer `k`. You need to delete **at most** `k` characters from `s`
> such that the run-length encoded version of `s` has **minimum** length.
> 
> Find _the minimum length of the run-length encoded version of `s` after deleting at most `k` characters_.

Example
-------

```sh
Input: s = "aaabcccd", k = 2
Output: 4
Explanation: Compressing s without deleting anything will give us "a3bc3d" of length 6.
    Deleting any of the characters 'a' or 'c' would at most decrease the length of the compressed string to 5,
    for instance delete 2 'a' then we will have s = "abcccd" which compressed is abc3d.
    Therefore, the optimal way is to delete 'b' and 'd', then the compressed version of s will be "a3c3" of length 4.
```

Solution
--------

| Task | Solution                          |
|:----:|:----------------------------------|
| 1531 | [String Compression II][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/string-compression-ii/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h16/p1531/option/Practice.java>
