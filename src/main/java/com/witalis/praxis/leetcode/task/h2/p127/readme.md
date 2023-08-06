# [LeetCode][leetcode] task # 127: [Word Ladder][task]

Description
-----------

> A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList`
> is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:
> * Every adjacent pair of words differs by a single letter.
> * Every `si` for `1 <= i <= k` is in `wordList`. Note that `beginWord` does not need to be in `wordList`.
> * `sk == endWord`
>
> Given two words, `beginWord` and `endWord`, and a dictionary `wordList`,
> return _the **number of words** in the **shortest transformation sequence**
> from `beginWord` to `endWord`, or `0` if no such sequence exists_.

Example
-------

```sh
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
```

Solution
--------

| Task | Solution                |
|:----:|:------------------------|
| 127  | [Word Ladder][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/word-ladder/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h2/p127/option/Practice.java>
