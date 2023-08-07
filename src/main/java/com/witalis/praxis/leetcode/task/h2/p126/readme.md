# [LeetCode][leetcode] task # 126: [Word Ladder II][task]

Description
-----------

> A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList`
> is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:
> * Every adjacent pair of words differs by a single letter.
> * Every `si` for `1 <= i <= k` is in `wordList`. Note that `beginWord` does not need to be in `wordList`.
> * `sk == endWord`
>
> Given two words, `beginWord` and `endWord`, and a dictionary `wordList`,
> return _all the **shortest transformation sequences** from `beginWord` to `endWord`,
> or an empty list if no such sequence exists_.
> Each sequence should be returned as a list of the words `[beginWord, s1, s2, ..., sk]`.

Example
-------

```sh
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
    "hit" -> "hot" -> "dot" -> "dog" -> "cog"
    "hit" -> "hot" -> "lot" -> "log" -> "cog"
```

Solution
--------

| Task | Solution                   |
|:----:|:---------------------------|
| 126  | [Word Ladder II][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/word-ladder-ii/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h2/p126/option/Practice.java>
