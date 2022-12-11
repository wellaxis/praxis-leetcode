# [LeetCode][leetcode] task # 1657: [Determine if Two Strings Are Close][task]

Description
-----------

> Two strings are considered **close** if you can attain one from the other using the following operations:
> * Operation 1: Swap any two **existing** characters.
> ** For example, `abcde -> aecdb`
> * Operation 2: Transform **every** occurrence of one existing character into another existing character,
> and do the same with the other character.
> ** For example, `aacabb -> bbcbaa` (all `a`'s turn into `b`'s, and all `b`'s turn into `a`'s)
>
> You can use the operations on either string as many times as necessary.
> 
> Given two strings, `word1` and `word2`, return _`true` if `word1` and `word2` are **close**, and `false` otherwise_.

Example
-------

```sh
Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
    Apply Operation 1: "cabbba" -> "caabbb"
                          _  _        _  _
    Apply Operation 2: "caabbb" -> "baaccc"
                        _  ___      _  ___
    Apply Operation 2: "baaccc" -> "abbccc"
                        ___         ___
```

Solution
--------

| Task | Solution                                       |
|:----:|:-----------------------------------------------|
| 1657 | [Determine if Two Strings Are Close][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/determine-if-string-halves-are-alike/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h17/p1657/option/Practice.java>
